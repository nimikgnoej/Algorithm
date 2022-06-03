#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>
using namespace std;

int l,r,c;
int dx[]={1,0,0,-1,0,0};
int dy[]={0,0,1,0,0,-1};
int dz[]={0,-1,0,0,1,0};
char map[31][31][31];
bool visited[31][31][31];
int dist[31][31][31];
queue<pair<int,pair<int,int>>> q;

void clear(){
  for(int i=0;i<l;i++){
    for(int j=0;j<r;j++){
      for(int x=0;x<c;x++){
        map[j][x][i]='C';
      }
    }
  }
  memset(visited,false,sizeof(visited));
  memset(dist,0,sizeof(dist));
  q=queue<pair<int,pair<int,int>>>();
}

int bfs(int x,int y,int z){
  q.push(make_pair(x,make_pair(y,z)));
  visited[x][y][z]=true;
  while(!q.empty()){
    x=q.front().first;
    y=q.front().second.first;
    z=q.front().second.second;
    q.pop();
    if(map[x][y][z]=='E')
      return dist[x][y][z];
    for(int k=0;k<6;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      int nz=z+dz[k];
      if(0<=nx&&nx<r&&0<=ny&&ny<c&&0<=nz&&nz<l){
        if(map[nx][ny][nz]=='.'||map[nx][ny][nz]=='E'){
          if(visited[nx][ny][nz]==false){
            q.push(make_pair(nx,make_pair(ny,nz)));
            visited[nx][ny][nz]=true;
            dist[nx][ny][nz]=dist[x][y][z]+1;
          }
        }
      }
    }
  }
  return -1;
}

int main()
{
  //freopen("input.txt","r",stdin);
  while(true){
    clear();
    int res;
    cin>>l>>r>>c;
    if(l==0&&r==0&&c==0)
      break;
    for(int i=0;i<l;i++){
      for(int j=0;j<r;j++){
        for(int x=0;x<c;x++){
          cin>>map[j][x][i];
        }
      }
    }
    for(int i=0;i<l;i++){
      for(int j=0;j<r;j++){
        for(int x=0;x<c;x++){
          if(map[j][x][i]=='S')
            res=bfs(j,x,i);
        }
      }
    }
    if(res==-1)
      cout<<"Trapped!"<<'\n';
    else
      cout<<"Escaped in "<<res<<" minute(s)."<<'\n';
  }
}