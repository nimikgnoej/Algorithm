#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

queue<pair<int,int>> q;
int M,N,K; //가로 세로 길이, 배추 개수
int check[51][51];  //방문했는지 확인하는
int a[51][51]; //인접행렬
int dx[] = {0,-1,0,1};  //한칸씩 움직일때 필요
int dy[] = {1,0,-1,0};

void bfs(int x,int y){
  q.push(make_pair(x,y)); check[x][y] = 1;
  while(!q.empty()){
    x=q.front().first; y=q.front().second;
    q.pop();
    for(int k=0;k<4;k++){
      int nx=x+dx[k]; int ny=y+dy[k];
      if(0<=nx&&nx<M && 0<=ny&&ny<N){
        if(a[nx][ny]==0||check[nx][ny]==1)
          continue;         
        q.push(make_pair(nx,ny));
        check[nx][ny]=1;   
      }
    }
  }
}

int main()
{
  int t;
  int cnt;
  cin>>t;
  while(t--){
    cnt=0;
    cin>>M>>N>>K;
    memset(a, 0, sizeof(a));
    memset(check, 0, sizeof(check));
    for(int i=0;i<K;i++){
      int from,to;
      cin>>from>>to;
      a[from][to]=1;
    }
    for(int i=0;i<M;i++){
      for(int j=0;j<N;j++){
        if(a[i][j]==1&&check[i][j]==0){
          bfs(i,j);
          cnt++;
        }
      }
    }
    cout<<cnt<<'\n';
  }
}