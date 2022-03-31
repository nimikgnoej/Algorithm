#include <iostream>
#include <cstring>
using namespace std;

int w,h;
int number; //섬의 개수
int map[51][51];
int visited[51][51];
int dx[]={0,1,1,1,0,-1,-1,-1};
int dy[]={1,1,0,-1,-1,-1,0,1};

void dfs(int y,int x){
  visited[y][x]=1;
  for(int k=0;k<8;k++){
    int nx=x+dx[k];
    int ny=y+dy[k];
    if(0<=nx&&nx<w && 0<=ny&&ny<h){
      if(map[ny][nx]==1 && visited[ny][nx]==0){
        dfs(ny,nx);
      }
    }
  }
}

int main() {
  while(true){
    cin>>w>>h;
    if(w==0&&h==0)
      break;

    for(int i=0;i<h;i++){
      for(int j=0;j<w;j++){
        cin>>map[i][j];
      }
    }

    for(int i=0;i<h;i++){
      for(int j=0;j<w;j++){
        if(visited[i][j]==0&&map[i][j]==1){ //방문 안했고, 길이 있다면
          number++;
          dfs(i,j);
        }
      }
    }
    cout<<number<<'\n';

    number=0;
    memset(visited,0,sizeof(visited));
  }
}