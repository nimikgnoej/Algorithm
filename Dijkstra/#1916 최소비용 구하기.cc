#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#define MAX 2e9
using namespace std;

int n,m,st,fi;
vector<pair<int,int>> map[1001];
int dist[1001];
priority_queue<pair<int,int>> pq;

void ds(int start){
  pq.push({0,start}); //거리,노드 순으로 push
  dist[start]=0;
  while(!pq.empty()){
    int distance=-pq.top().first;
    int now=pq.top().second;
    pq.pop();
    if(dist[now]<distance) continue;
    for(int k=0;k<map[now].size();k++){
      int cost=distance+map[now][k].second;
      if(cost<dist[map[now][k].first]){
        dist[map[now][k].first]=cost;
        pq.push({-cost,map[now][k].first});
      }
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n;
  cin>>m;
  for(int i=0;i<m;i++){
    int a,b,c;
    cin>>a>>b>>c;
    map[a].push_back({b,c}); //a에서 b로 가는 비용이 c이다.
  }
  cin>>st>>fi;
  fill_n(dist,1001,MAX);
  ds(st);
  cout<<dist[fi];
}