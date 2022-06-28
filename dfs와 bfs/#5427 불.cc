#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

int w,h,hour;
char map[1001][1001];
bool visited[1001][1001];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
queue<pair<int,int>> q;
queue<pair<int,int>> fq; //불 이동을 위한 큐

void print(){
  for(int i=0;i<h;i++){
    for(int j=0;j<w;j++){
      cout<<map[i][j]<<" ";
    }
    cout<<'\n';
  }
}

bool bfs(){
  hour=0;
  while(!q.empty()){
    hour++;
    int fqsize=fq.size();
    int hqsize=q.size();
    while(fqsize--){
      int x=fq.front().first;
      int y=fq.front().second;
      fq.pop();
      for(int k=0;k<4;k++){
        int nx=x+dx[k];
        int ny=y+dy[k];
        if(nx<0||ny<0||nx>=h||ny>=w) continue;
        if(map[nx][ny]=='#') continue;
        if(visited[nx][ny]) continue;
        fq.push({nx,ny});
        visited[nx][ny]=true;
      }
    }
    while(hqsize--){
      int x=q.front().first;
      int y=q.front().second;
      q.pop();
      for(int k=0;k<4;k++){
        int nx=x+dx[k];
        int ny=y+dy[k];
        if(nx<0||ny<0||nx>=h||ny>=w) return true;
        if(map[nx][ny]=='#') continue;
        if(visited[nx][ny]) continue;
        q.push({nx,ny});
        visited[nx][ny]=true;
      }
    }
  }
  return false;
}

int main()
{
  ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
  int t;
  cin>>t;
  while(t--){
    memset(visited,false,sizeof(visited));
    while(!fq.empty()) fq.pop();
    while(!q.empty()) q.pop();
    
    cin>>w>>h;
    for(int i=0;i<h;i++){
      for(int j=0;j<w;j++){
        cin>>map[i][j];
        if(map[i][j]=='@'){
          q.push({i,j});
          visited[i][j]=true;
          map[i][j]='.';
        }
        else if(map[i][j]=='*'){
          fq.push({i,j});
          visited[i][j]=true;
        }
      }
    }
    bool res=bfs();
    if(res)
      cout<<hour<<'\n';
    else
      cout<<"IMPOSSIBLE"<<'\n';
  }
}