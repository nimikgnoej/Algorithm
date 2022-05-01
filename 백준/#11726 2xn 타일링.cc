#include <iostream>
#include <algorithm>
#define mod 10007
using namespace std;

long long dp[1001];

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  cin>>n;
  dp[1]=1;
  dp[2]=2;
  for(int i=3;i<=n;i++){
    dp[i]=(dp[i-1]+dp[i-2])%mod;
  }

  cout<<dp[n]%mod;
}