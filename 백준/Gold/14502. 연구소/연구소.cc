#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>
using namespace std;

int map[10][10];
int copy_map[10][10];
int visited[10][10];
int dxy[4][2]={{0,1},{1,0},{0,-1},{-1,0}};
int n,m,ans;
int w=3;

void bfs(){
  for(int i=1;i<=n;i++){
    for(int j=1;j<=m;j++){
      copy_map[i][j]=map[i][j];
    }
  }
  for(int i=1;i<=n;i++){
    for(int j=1;j<=m;j++){
      if(copy_map[i][j]==2){
        queue<pair<int,int>> q;
        q.push(make_pair(i,j));
        visited[i][j]=1;
        while(!q.empty()){
          int y=q.front().first;
          int x=q.front().second;
          q.pop();
          for(int k=0;k<4;k++){
            int nx=x+dxy[k][0];
            int ny=y+dxy[k][1];
            if(copy_map[ny][nx]==0 && visited[ny][nx]==0){
              q.push(make_pair(ny,nx));
              visited[ny][nx]=1;
              copy_map[ny][nx]=2;
            }
          }
        }
      }
    }
  }
  memset(visited,0,sizeof(visited));
  int area=0;
  for(int i=1;i<=n;i++){
    for(int j=1;j<=m;j++){
      if(copy_map[i][j]==0){
        area++;
      }
    }
  }
  if(ans<area)
    ans=area;
}

void wall(){ //w는 3으로 고정되어 있쟈냐
  if(w==0)
    return bfs();
  for(int i=1;i<=n;i++){
    for(int j=1;j<=m;j++){
      if(map[i][j]==0){
        w--;
        map[i][j]=1;
        wall();
        w++;
        map[i][j]=0;
      }
    }
  }
}

int main() {
  //freopen("input.txt","r",stdin);
  cin>>n>>m;
  memset(map,-1,sizeof(map));
  memset(copy_map,-1,sizeof(copy_map));
  for(int i=1;i<=n;i++){
    for(int j=1;j<=m;j++){
      cin>>map[i][j];
    }
  }
  wall();

  cout<<ans<<'\n';
  
/*
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cout<<map[i][j]<<" ";
    }
    cout<<'\n';
  }
  cout<<'\n';
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cout<<copy_map[i][j]<<" ";
    }
    cout<<'\n';
  }
 */
}