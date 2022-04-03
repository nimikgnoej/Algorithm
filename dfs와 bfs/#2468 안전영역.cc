#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

int n,maxH;
int cnt[101];
int map[101][101];
int visited[101][101];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
queue<pair<int,int>> q;

void bfs(int x,int y,int rain){
  q.push(make_pair(x,y));
  visited[x][y]=1;
  
  while(!q.empty()){
    x=q.front().first; y=q.front().second;
    q.pop();
    for(int k=0;k<4;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<=nx&&0<=ny && nx<n&&ny<n){
        if(map[nx][ny]>rain&&visited[nx][ny]==0){
          q.push(make_pair(nx,ny));
          visited[nx][ny]=1;
        }
      }
    }
  }
}

int main()
{
  int rainH=0;
  cin>>n;
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      cin>>map[i][j];
    }
  }

  for(int i=0;i<n;i++){ //최대높이 계산
    for(int j=0;j<n;j++){
      if(maxH<map[i][j])
        maxH=map[i][j];
    }
  }
  while(rainH<=maxH){
    for(int i=0;i<n;i++){ //비가 0왔을때 부터 ~ 최대높이까지 왔을때
      for(int j=0;j<n;j++){
        if(map[i][j]>rainH&&visited[i][j]==0){
          bfs(i,j,rainH);
          cnt[rainH]++;
        }
      }
    }
    rainH++;
    memset(visited,0,sizeof(visited));
  }
  
  
  cout<<*max_element(cnt,cnt+maxH)<<'\n';
}