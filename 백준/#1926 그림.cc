#include <iostream>
#include <queue>
using namespace std;

int n,m,cnt;
int area;//그림 넓이 최대
int value;
int map[501][501];
int visited[501][501];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
queue<pair<int,int>> q;

void bfs(int x,int y){
  value=1;
  q.push(make_pair(x,y));
  visited[x][y]=1;
  while(!q.empty()){
    x=q.front().first;
    y=q.front().second;
    q.pop();
    for(int k=0;k<4;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<=nx && nx<n && 0<=ny && ny<m){
        if(map[nx][ny]==1 && visited[nx][ny]==0){
          q.push(make_pair(nx,ny));
          visited[nx][ny]=1;
          value++;
        }
      }
    }
  }
  if(area<value)
    area=value;
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>m;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cin>>map[i][j];
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(map[i][j]==1 && visited[i][j]==0){
        bfs(i,j);
        cnt++;
      }
    }
  }

  cout<<cnt<<'\n'<<area;
}