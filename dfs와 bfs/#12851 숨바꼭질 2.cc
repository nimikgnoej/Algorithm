#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#define MAX 100000
using namespace std;

int n,k;
vector<int> visited(100001);
vector<int> dist(100001);
int cnt[100001];
queue<int> q;

void bfs(int x){
  for(int i=0;i<100001;i++){
    dist[i]=2147000000;
  }
  cnt[x]=1;
  dist[x]=0;
  q.push(x);
  visited[x]=1; 
  while(!q.empty()){
    int now=q.front();
    q.pop();
    if(2*now<=MAX && dist[2*now]>=(dist[now]+1)){
      if(dist[2*now]==(dist[now]+1)){
        cnt[2*now]+=cnt[now];
      }
      else{
        dist[2*now]=dist[now]+1; 
        cnt[2*now]+=cnt[now];
        q.push(2*now);
      } 
    }
    if(now-1>=0&&dist[now-1]>=(dist[now]+1)){
      if(dist[now-1]==(dist[now]+1)){
        cnt[now-1]+=cnt[now];
      }
      else{
        dist[now-1]=dist[now]+1; 
        cnt[now-1]+=cnt[now];
        q.push(now-1);
      }
    }
    if(now+1<=MAX&&dist[now+1]>=(dist[now]+1)){
      if(dist[now+1]==(dist[now]+1)){
        cnt[now+1]+=cnt[now];
      }
      else{
        dist[now+1]=dist[now]+1; 
        cnt[now+1]+=cnt[now];
        q.push(now+1);
      }
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>k;
  bfs(n);
  cout<<dist[k]<<'\n';
  if(n==k){
    cout<<"1";
    return 0;
  }
  cout<<cnt[k];
}