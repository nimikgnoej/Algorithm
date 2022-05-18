#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <cstring>
#include <queue>
using namespace std;

int row,col;
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
vector<int> treasure;
queue<pair<int,int>>q;
char map[51][51];
vector<vector<int>> dist(51,vector<int>(51,0));
int visited[51][51];

int mega(vector<vector<int>> &copy){
  int maxnum=0;
  for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
      if(maxnum<dist[i][j])
        maxnum=dist[i][j];
    }
  }

  return maxnum;
}

void bfs(int x,int y){
  q.push(make_pair(x,y));
  visited[x][y]=1;
  while(!q.empty()){
    x=q.front().first;
    y=q.front().second;
    q.pop();
    for(int k=0;k<4;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<=nx && nx<row && 0<=ny && ny<col){
        if(map[nx][ny]=='L' && visited[nx][ny]==0){
          q.push(make_pair(nx,ny));
          visited[nx][ny]=1;
          dist[nx][ny]=dist[x][y]+1;
        }
      }
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  string str;
  cin>>row>>col;

  for(int i=0;i<row;i++){
    cin>>str;
    for(int j=0;j<col;j++){
      map[i][j]=str[j];
    }
  }

  for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
      if(map[i][j]=='L'&&visited[i][j]==0){
        bfs(i,j);
        treasure.push_back(mega(dist));
        memset(visited,0,sizeof(visited));
        fill(dist.begin(),dist.end(),vector<int>(51,0));
      }
    }
  }

  cout<<*max_element(treasure.begin(),treasure.end());
}