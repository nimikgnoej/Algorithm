#include <iostream>
#include <algorithm>
using namespace std;

int n;
long long cnt;
long long dp[91][3];

int main()
{
  //freopen("input.txt","r",stdin);

  cin>>n;
  dp[1][0]=0;
  dp[1][1]=1;

  for(int i=2;i<=n;i++){
    dp[i][0]=dp[i-1][1]+dp[i-1][0];
    dp[i][1]=dp[i-1][0];
  }
  for(int i=0;i<2;i++){
    cnt+=dp[n][i];
  }

  cout<<cnt<<'\n';
}