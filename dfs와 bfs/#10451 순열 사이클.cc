#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

int N,cnt;
int map[1001][1001];
int graph[1001];
int visit[1001];

void dfs(int x){
  visit[x]=1;
  for(int i=1;i<=N;i++){
    if(visit[i]==0 && map[x][i]==1){
      dfs(i);
    }    
  }
}

int main(){
  int t;
  cin>>t;
  while(t--){
    cnt=0;
    memset(graph,0,sizeof(graph));
    memset(visit,0,sizeof(visit));
    memset(map,0,sizeof(map));
    cin>>N;
    
    for(int i=1;i<=N;i++){
      cin>>graph[i];
    }

    for(int i=1;i<=N;i++){
      map[i][graph[i]]=1;
    }
   
    for(int i=1;i<=N;i++){
      if(visit[i]==0&&map[i][graph[i]]==1){
        dfs(i);
        cnt++;
      }
    }
    cout<<cnt<<'\n';
  }
}