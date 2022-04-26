#include <iostream>
#include <algorithm>
#define mod 10007
using namespace std;

int n;
long long dp[1001];

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n;
  dp[1]=1;
  dp[2]=3;

  for(int i=3;i<=n;i++){
    dp[i]=(dp[i-1]+dp[i-2]+dp[i-2])%mod;
  }

  cout<<dp[n]%mod;
}