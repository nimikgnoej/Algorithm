#include <iostream>
#include <queue>
using namespace std;

int n,m,v;
int check[1001] = {0,};
int mat[1001][1001];
queue<int> q;

void dfs(int x){
  check[x] = 1;
  cout<<x<<" ";
  for(int i=0;i<n+1;i++){
    if(mat[x][i] == 1 && check[i]==0)
      dfs(i);
  }
}

void fuck(int x){
  check[x] = 1;
  q.push(x);
  while(!q.empty()){
    x = q.front();
    q.pop();
    cout<<x<<" ";
    for(int i= 1;i<n+1;i++){
      if(mat[x][i]==1&&check[i]==0){
        q.push(i);
        check[i]=1;
      }
    }
  }
}

void reset(){
  for(int i=0;i<=n;i++){
    check[i]=0;
  }
}
int main(){
  cin>>n>>m>>v;
  while(m--){
    int a,b;
    cin>>a>>b;
    mat[a][b] = 1;
    mat[b][a] = 1;
  }
  dfs(v);
  reset();
  cout<<endl;
  fuck(v);
}