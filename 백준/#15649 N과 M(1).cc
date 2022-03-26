#include <iostream>
using namespace std;

bool check[10]; //쓴적이 있는 숫자라면 true
int ans[10]; //답을 담을 공간

void go(int index,int n,int m)
{
  if(index==m){
    //수열 출력내용
    for(int k=0;k<m;k++){
      cout<<ans[k]<<" ";
    }
    cout<<'\n';
    return;
  }
  for(int i=1;i<=n;i++){
    if(check[i])
      continue;
    check[i]=true;
    ans[index]=i;
    go(index+1,n,m);
    check[i]=false;
  }
}

int main()
{
  int n,m;
  cin>>n>>m;
  go(0,n,m);
}