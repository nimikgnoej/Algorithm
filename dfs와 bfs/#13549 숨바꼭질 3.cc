#include <iostream>
#include <algorithm>
#include <queue>
#define MAX 100000
using namespace std;

int n,k;
int dist[100001];
int visited[100001];
queue<int> q;

void bfs(int x){
  q.push(x);
  visited[x]=1;
  while(!q.empty()){
    int now=q.front();
    q.pop();
    if(2*now<=MAX && visited[2*now]==0){
      q.push(2*now);
      dist[2*now]=dist[now];
      visited[2*now]=1;
    }
    if(0<=now-1 && visited[now-1]==0){
      q.push(now-1);
      dist[now-1]=dist[now]+1;
      visited[now-1]=1;
    }
    if(now+1<=MAX && visited[now+1]==0){
      q.push(now+1);
      dist[now+1]=dist[now]+1;
      visited[now+1]=1;
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>k;

  bfs(n);
  cout<<dist[k];
}