#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>
using namespace std;

int n,cnt,cow;
char map[101][101];
int visited[101][101];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
queue<pair<int,int>> q;

void bfs(int x,int y,char c){
  q.push(make_pair(x,y));
  visited[x][y]=1;
  while(!q.empty()){
    x=q.front().first;
    y=q.front().second;
    q.pop();
    for(int k=0;k<4;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<=nx && nx<n && 0<=ny && ny<n){
        if(map[nx][ny]==c && visited[nx][ny]==0){
          q.push(make_pair(nx,ny));
          visited[nx][ny]=1;
        }
      }
    }
  }
}

void cowbfs(int x,int y,char c){
  q.push(make_pair(x,y));
  visited[x][y]=1;
  while(!q.empty()){
    x=q.front().first;
    y=q.front().second;
    q.pop();
    for(int k=0;k<4;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<=nx && nx<n && 0<=ny && ny<n){
        if(c=='R' || c=='G'){
          if(map[nx][ny]=='R' || map[nx][ny]=='G'){
            if(visited[nx][ny]==0){
              q.push(make_pair(nx,ny));
              visited[nx][ny]=1;
            }
          }
        }
        else if(c=='B'){
          if(map[nx][ny]==c && visited[nx][ny]==0){
            q.push(make_pair(nx,ny));
            visited[nx][ny]=1;
          }
        }
      }
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n;
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      cin>>map[i][j];
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(map[i][j]=='R' && visited[i][j]==0){
        bfs(i,j,'R');
        cnt++;
      }
      
      if(map[i][j]=='G' && visited[i][j]==0){
        bfs(i,j,'G');
        cnt++;
      }
      
      if(map[i][j]=='B' && visited[i][j]==0){
        bfs(i,j,'B');
        cnt++;
      }
    }
  }
  memset(visited,0,sizeof(visited));
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(map[i][j]=='R' && visited[i][j]==0){
        cowbfs(i,j,'R');
        cow++;
      }

      if(map[i][j]=='G' && visited[i][j]==0){
        cowbfs(i,j,'G');
        cow++;
      }
      
      if(map[i][j]=='B' && visited[i][j]==0){
        cowbfs(i,j,'B');
        cow++;
      }
    }
  }

  cout<<cnt<<" "<<cow<<'\n';
}