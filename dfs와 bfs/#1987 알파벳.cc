#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int r,c,ans;
char board[21][21];
int check[26];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};

void dfs(int x,int y,int cnt){
  if(cnt>ans)
    ans=cnt;
  check[board[x][y]-'A']=1;
  for(int k=0;k<4;k++){
    int nx=x+dx[k];
    int ny=y+dy[k];
    if(0<=nx&&nx<r && 0<=ny && ny<c){
      if(check[board[nx][ny]-'A']==0){
        check[board[nx][ny]-'A']=1;
        dfs(nx,ny,cnt+1);
        check[board[nx][ny]-'A']=0;
      }
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>r>>c;
  for(int i=0;i<r;i++){
    for(int j=0;j<c;j++){
      cin>>board[i][j];
    }
  }
  dfs(0,0,1);
  
  cout<<ans;
}