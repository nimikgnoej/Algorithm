#include <queue>
#include <algorithm>
#include <cstdio>
using namespace std;

int n; //지도의 크기 nxn
int graph[30][30]; //지도
int d[25][25]; //방문했는지 체크
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
int sum[25*25]; //각 단지의 집의 개수를 넣을 배열


void bfs(int x,int y,int cnt){
  queue<pair<int,int>> q;
  q.push(make_pair(x,y));
  d[x][y]=cnt;
  while(!q.empty()){
    x=q.front().first; y=q.front().second;
    q.pop();
    for(int i=0;i<4;i++){
      int nx=x+dx[i]; int ny=y+dy[i];
      if(0<=nx&&nx<n && 0<=ny&&ny<n)
        if(graph[nx][ny]==1&&d[nx][ny]==0){
          q.push(make_pair(nx,ny));
          d[nx][ny]=cnt;
        }
    }
  }
}

int main()
{
  scanf("%d",&n); //지도크기 입력
  for(int i=0;i<n;i++){ //지도 입력 구간
    for(int j=0;j<n;j++){
      scanf("%1d",&graph[i][j]);
    }
  }
  int cnt=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(graph[i][j]==1&&d[i][j]==0){ //집이있고, 방문한적이 없으면..
        bfs(i,j,++cnt);
      }
    }
  }
  printf("%d\n",cnt);

  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      sum[d[i][j]]++;
    }
  }
  sort(sum+1,sum+cnt+1); 
  for(int k=1;k<=cnt;k++){
    printf("%d\n",sum[k]);
  }
}