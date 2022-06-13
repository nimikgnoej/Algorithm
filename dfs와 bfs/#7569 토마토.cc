#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int m,n,h; //가로 m 세로 n 높이 h
int box[101][101][101];
int visited[101][101][101];
int dist[101][101][101];
int dx[]={0,1,0,-1,0,0};
int dy[]={1,0,-1,0,0,0};
int dz[]={0,0,0,0,1,-1};

void bfs(){
  queue<pair<int,pair<int,int>>> q; //x,(y,z) 식으로 push 해야함
  for(int k=0;k<h;k++){
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(box[i][j][k]==1){
          q.push({i,{j,k}});
          visited[i][j][k]=1;
        }
      }
    }
  }
  while(!q.empty()){
    int x=q.front().first;
    int y=q.front().second.first;
    int z=q.front().second.second;
    q.pop();
    for(int k=0;k<6;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      int nz=z+dz[k];
      if(0<=nx&&nx<n&&0<=ny&&ny<m&&0<=nz&&nz<h){
        if(box[nx][ny][nz]==0 && visited[nx][ny][nz]==0){
          q.push({nx,{ny,nz}});
          visited[nx][ny][nz]=1;
          dist[nx][ny][nz]=dist[x][y][z]+1;
        }
      }
    }
  }
}

int solve(){
  for(int k=0;k<h;k++){
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(visited[i][j][k]==0&&box[i][j][k]==0)
          return -1;
      }
    }
  }
  return 1;
}

void answer(){
  int big=dist[0][0][0];
  for(int k=0;k<h;k++){
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(big<dist[i][j][k])
          big=dist[i][j][k];
      }
    }
  }
  cout<<big;
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>m>>n>>h;
  for(int k=0;k<h;k++){
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        cin>>box[i][j][k];
      }
    }
  }
  bfs();
  if(solve()==-1)
    cout<<"-1";
  else
    answer();
}