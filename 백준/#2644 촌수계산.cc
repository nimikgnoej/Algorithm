#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int n,m;
int person1,person2;
int a[101][101];
int visited[101];
int dist[101];
queue<int> q;

void bfs(int x){
  visited[x]=1;
  q.push(x);
  while(!q.empty()){
    x=q.front();
    q.pop();
    for(int i=1;i<=n;i++){
      if(a[x][i]==1&&visited[i]==0){
        q.push(i);
        visited[i]=1;
        dist[i]=dist[x]+1;
      }
    }
  }
}

int main()
{
  cin>>n;
  cin>>person1>>person2;
  cin>>m;
  while(m--){
    int from,to;
    cin>>from>>to;
    a[from][to]=1;
    a[to][from]=1;
  }
  bfs(person1);
  if(dist[person2]==0)
    cout<<"-1"<<'\n';
  else
    cout<<dist[person2]<<'\n';
}