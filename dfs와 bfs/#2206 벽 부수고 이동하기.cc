#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <cstring>
using namespace std;

int n,m;
int map[1001][1001];
int visited[1001][1001][2];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
queue<pair<pair<int,int>,int>> q;

int bfs(int x,int y){
  q.push(make_pair(make_pair(x,y),1));
  visited[x][y][1]=1;
  while(!q.empty()){
    x=q.front().first.first;
    y=q.front().first.second;
    int block=q.front().second;
    q.pop();
    if(x==n && m==y)
      return visited[x][y][block];
    for(int k=0;k<4;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<nx && nx<=n && 0<ny && ny<=m){
        if(map[nx][ny]==1 && block){
          visited[nx][ny][block-1]=visited[x][y][block]+1;
          q.push(make_pair(make_pair(nx,ny),block-1));
        }
        if(map[nx][ny]==0 && visited[nx][ny][block]==0){
          visited[nx][ny][block]=visited[x][y][block]+1;
          q.push(make_pair(make_pair(nx,ny),block));
        }
      }
    }
  }
  return -1;
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>m;
  for(int i=1;i<=n;i++){
    for(int j=1;j<=m;j++){
      scanf("%1d",&map[i][j]);
    }
  }
  
  cout<<bfs(1,1);
}