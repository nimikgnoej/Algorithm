#include <iostream>
#include <algorithm>
#define mod 9901
using namespace std;

long long dp[100001][3];

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  int ans=0;
  cin>>n;
  dp[1][0]=1;
  dp[1][1]=1;
  dp[1][2]=1;

  for(int i=2;i<=n;i++){
    dp[i][0]=(dp[i-1][1]+dp[i-1][2])%mod;
    dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
    dp[i][2]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%mod;
  }

  for(int i=0;i<3;i++){
    ans+=dp[n][i];
  }

  cout<<ans%mod;
}