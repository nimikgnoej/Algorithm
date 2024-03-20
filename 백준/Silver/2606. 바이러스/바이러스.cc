#include <iostream>
#include <vector>
using namespace std;

vector<int> com[101]; //컴퓨터
int n,m; //컴퓨터 개수와 간선의 개수
int check[101];
int cnt;

void dfs(int x){
  check[x]=1; //방문 기록
  for(int i=0;i<com[x].size();i++){
    int next=com[x][i];
    if(check[next]==0){
      cnt++;
      dfs(next);
    }
  }
}

int main()
{
  cin>>n;
  cin>>m;
  while(m--){
    int from,to;
    cin>>from>>to;
    com[from].push_back(to);
    com[to].push_back(from);
  }
  dfs(1);

  cout<<cnt<<'\n';
}