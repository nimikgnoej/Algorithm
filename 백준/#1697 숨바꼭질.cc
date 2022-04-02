#include <iostream>
#include <queue>
#define MAX 100000
using namespace std;

int n,k;
int visited[100001];
int dist[100001];
queue<int> q;

void bfs(int x){
  visited[x]=1;
  dist[x]=0;
  q.push(x);
  while(!q.empty()){
    int now=q.front();
    q.pop();
    if(now-1>=0&&visited[now-1]==0){
      q.push(now-1);
      visited[now-1]=1;
      dist[now-1]=dist[now]+1;
    }
    if(now+1<=MAX&&visited[now+1]==0){
      q.push(now+1);
      visited[now+1]=1;
      dist[now+1]=dist[now]+1;
    }
    if(2*now<=MAX&&visited[2*now]==0){
      q.push(2*now);
      visited[2*now]=1;
      dist[2*now]=dist[now]+1;
    }
  }
}

int main() {
  cin>>n>>k;

  bfs(n);
  cout<<dist[k]<<'\n';
}