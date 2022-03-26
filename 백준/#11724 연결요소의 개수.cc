#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<vector<int>> a(1001,vector<int>(1001,0));
int N,M,V;
int check[1001];
queue<int> q;
void reset(){
  for(int i=0;i<=N;i++){
    check[i]=0;
  }
}

void bfs(int x){
  q.push(x);
  check[x]=1;
  while(!q.empty()){
    //cout<<q.front()<<" ";
    x=q.front();
    q.pop();
    for(int i=1;i<=N;i++){
      if(a[x][i]==1&&check[i]==0){
        q.push(i);
        check[i]=1;
      }
    }
  }
}

int SUM(){
  int sum=0;
  for(int i=1;i<=N;i++){
    sum+=check[i];
  }
  return sum;
}

int main()
{
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int cc=0;
  int idx=0;  
  cin>>N>>M;
  while(M--){
    int n1,n2;
    cin>>n1>>n2;
    a[n1][n2]=1;
    a[n2][n1]=1;
  }
  reset();

  for(int i = 1; i <= N; i++){
    if (!check[i]){
      bfs(i);
      cc++;
    }
  }
  cout << cc;
}