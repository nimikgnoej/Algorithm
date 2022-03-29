#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;

int cnt=1;
int n,m;
int map[101][101];
int visited[101][101];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
int dist[101][101];
queue<pair<int,int>> q;

void bfs(int x,int y){
  q.push(make_pair(x,y));
  visited[x][y]=1;
  dist[x][y]++;
  while(!q.empty()){
    x=q.front().first; y=q.front().second;
    q.pop();
    for(int k=0;k<4;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<nx&&nx<=n && 0<ny&&ny<=m){
        if(map[nx][ny]==1&&visited[nx][ny]==0){
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
  cin>>n>>m;
  for(int i=1;i<=n;i++){
    string a;
    cin>>a;
    for(int j=1;j<=m;j++)
      map[i][j]=a[j-1]-'0';
  }

  bfs(1,1);
  cout<<dist[n][m]<<'\n';
}