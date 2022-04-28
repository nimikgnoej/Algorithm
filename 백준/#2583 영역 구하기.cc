#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int m,n,k;
int map[101][101];
int visited[101][101];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
vector<int> area;
int cnt,AREA;
queue<pair<int,int>> q;

void bfs(int x,int y){
  q.push(make_pair(x,y));
  visited[x][y]=1;
  AREA=0;
  while(!q.empty()){
    x=q.front().first;
    y=q.front().second;
    q.pop();
    for(int z=0;z<4;z++){
      int nx=x+dx[z];
      int ny=y+dy[z];
      if(0<=nx && nx<m && 0<=ny && ny<n){
        if(map[nx][ny]==0 && visited[nx][ny]==0){
          q.push(make_pair(nx,ny));
          visited[nx][ny]=1;
          AREA++;
        }
      }
    }
  }
  area.push_back(AREA);
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>m>>n>>k;
  int coord[k][4];
  for(int i=0;i<k;i++){
    for(int j=0;j<4;j++){
      cin>>coord[i][j];
    }
  }

  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
      for(int x=0;x<k;x++){
        if(m-coord[x][1]>i && i>=m-coord[x][3] && coord[x][0]<=j && j<coord[x][2])
          map[i][j]=1;
      }
    }
  }

  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
      if(map[i][j]==0 && visited[i][j]==0){
        bfs(i,j);
        cnt++;
      }
    }
  }

  for(int i=0;i<area.size();i++)
    area[i]+=1;

  sort(area.begin(),area.end());
  cout<<cnt<<'\n';
  for(int i=0;i<area.size();i++)
    cout<<area[i]<<" ";
}