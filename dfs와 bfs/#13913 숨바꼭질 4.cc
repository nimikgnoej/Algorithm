#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>
#define MAX 100000
using namespace std;

int n,k;
vector<int> visited(100001);
vector<int> report(100001);
vector<int> dist(100001);
queue<int> q;
stack<int> stk;

void bfs(int x){
  q.push(x);
  visited[x]=1; 
  while(!q.empty()){
    int now=q.front();
    q.pop();
    if(now==k)
      return;
    if(2*now<=MAX && visited[2*now]==0){
      q.push(2*now);
      visited[2*now]=1;
      dist[2*now]=dist[now]+1;
      report[2*now]=now;      
    }
    if(now-1>=0&&visited[now-1]==0){
      q.push(now-1);
      visited[now-1]=1;
      dist[now-1]=dist[now]+1;
      report[now-1]=now;
    }
    if(now+1<=MAX&&visited[now+1]==0){
      q.push(now+1);
      visited[now+1]=1;
      dist[now+1]=dist[now]+1;
      report[now+1]=now;
    }
  }
}

//어떻게 이동해야하는지 이동정점을 기록하는 vector가 report임
int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>k;
  int sex=k;
  int prev;
  bfs(n);
  cout<<dist[k]<<'\n';
  while(sex!=n){
    stk.push(sex);
    prev=report[sex];
    sex=prev;
  }

  cout<<n<<" ";
  while(!stk.empty()){
    cout<<stk.top()<<" ";
    stk.pop();
  }
}