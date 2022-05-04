#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int podo[10001];
int dp[10001];

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  cin>>n;
  for(int i=1;i<=n;i++)
    cin>>podo[i];

  dp[1]=podo[1];
  dp[2]=podo[1]+podo[2];

  for(int i=3;i<=n;i++){
    dp[i]=max(dp[i-2]+podo[i],dp[i-3]+podo[i-1]+podo[i]);
    dp[i]=max(dp[i],dp[i-1]);
  }

  cout<<dp[n];
}