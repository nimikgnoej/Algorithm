#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;

long long dp[100001];

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  cin>>n;
  int num;

  for(int i=1;i<=n;i++){
    dp[i]=i;
    for(int j=1;j*j<=i;j++){
      if(dp[i]>dp[i-j*j]+1)
        dp[i] = dp[i-j*j]+1;
    }
  }

  cout<<dp[n];
}