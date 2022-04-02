#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int m,n,big;
int map[1001][1001];  //토마토 정보 입력 배열
int visited[1001][1001]; //방문기록
int date[1001][1001];  //최단 날짜
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
queue<pair<int,int>> q;

void bfs(){
  //q.push(make_pair(y,x));
  //visited[x][y]=1;
  while(!q.empty()){
    int y=q.front().first; int x=q.front().second;
    q.pop();
    for(int k=0;k<4;k++){
      int nx=x+dx[k];
      int ny=y+dy[k];
      if(0<=nx&&nx<n && 0<=ny&&ny<m){  //범위 확인
        if(map[nx][ny]==0&&visited[nx][ny]==0){
          q.push(make_pair(ny,nx));
          visited[nx][ny]=1;
          date[nx][ny]=date[x][y]+1;
        }
      }
    }
  }
}

int main()
{
  int flag=-1; 
  cin>>m>>n;

  for(int i=0;i<n;i++){ //토마토 정보 입력
    for(int j=0;j<m;j++){
      cin>>map[i][j];
      if(map[i][j]==1){
        q.push(make_pair(j,i));
        visited[i][j]=1;
      }
    }
  }
  
  bfs();
  
  for(int i=0;i<n;i++){  //안익은거 있으면 -1 출력
    for(int j=0;j<m;j++){
      if(visited[i][j]==0&&map[i][j]==0){
        cout<<"-1"<<'\n';
        return 0;
      }
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(big<date[i][j]){
        big=date[i][j];
      }
    }
  }
  cout<<big<<'\n';
}