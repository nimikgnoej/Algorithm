#include <iostream>
using namespace std;

long long memo[101];

long long pado(int n){
  if(n<=3)
    return 1;
  else if(n>3){
    if(memo[n]!=0)
      return memo[n];
    else if(memo[n]==0){
      memo[n]=pado(n-3)+pado(n-2);
      return memo[n];
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  int t;
  cin>>t;
  while(t--){
    int num;
    cin>>num;
    cout<<pado(num)<<'\n';
  }
}