#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#define MAX 2e9
using namespace std;

vector<int> map[300001];
priority_queue<pair<int,int>> pq;
int dist[300001];
int n,m,k,st;

void dijkstra(int start){
  pq.push({0,start}); //거리,노드 순으로 push
  dist[start]=0;
  while(!pq.empty()){
    int distance=-pq.top().first;
    int now=pq.top().second;
    pq.pop();
    if(dist[now]<distance) continue;

    for(int k=0;k<map[now].size();k++){
      int cost=distance+1;
      if(cost<dist[map[now][k]]){
        dist[map[now][k]]=cost;
        pq.push({-cost,map[now][k]});
      }
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>m>>k>>st;
  for(int i=0;i<m;i++){
    int a,b;
    cin>>a>>b;
    map[a].push_back(b); //a에서 b로 이동하는 간선이 있다.
  }
  fill_n(dist,300001,MAX);
  dijkstra(st);

  int idx=MAX;
  for(int i=0;i<=n;i++){
    if(dist[i]==k){
      idx=i;
      cout<<idx<<'\n';
    }
  }

  if(idx==MAX)
    cout<<"-1";
}