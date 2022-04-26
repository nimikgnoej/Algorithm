#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int n,cnt;
int fromx,fromy,tox,toy;
int dist[301][301];
int visited[301][301];
int dx[]={-2,-1,1,2,2,1,-1,-2};
int dy[]={1,2,2,1,-1,-2,-2,-1};
queue<pair<int,int>> q;

void reset(){
  for (int i = 0; i < n; i++){
    for (int j = 0; j < n; j++){
      visited[i][j] = 0;
      dist[i][j] = 0;
    }
  }
  while(!q.empty()){
    q.pop();
  }
}

void bfs(int x,int y){
  q.push(make_pair(x,y));
  visited[x][y]=1;
  while(!q.empty()){
    x=q.front().first;
    y=q.front().second;
    q.pop();
    for(int k=0;k<8;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<=nx && nx<n && 0<=ny && ny<n){
        if(visited[nx][ny]==0){
          q.push(make_pair(nx,ny));
          visited[nx][ny]=1;
          dist[nx][ny]=dist[x][y]+1;
          if(nx==tox && ny==toy) return;
        }
      }
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  int t;
  cin>>t;
  while(t--){
    cin>>n;
    cin>>fromx>>fromy;
    cin>>tox>>toy;
    reset();

    if(fromx==tox && fromy==toy){
      cout<<"0"<<'\n';
    }
    else{
      bfs(fromx,fromy);
      cout<<dist[tox][toy]<<'\n';
    }
  }
}