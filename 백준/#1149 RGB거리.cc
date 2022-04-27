#include <iostream>
#include <algorithm>
using namespace std;

int dp[1001][3];
int cost[1001][3];

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  cin>>n;
  for(int i=0;i<n;i++){
    for(int j=0;j<3;j++){
      cin>>cost[i][j];
    }
  }

  dp[1][0]=cost[0][0];
  dp[1][1]=cost[0][1];
  dp[1][2]=cost[0][2];
  
  for(int i=2;i<=n;i++){
    dp[i][0]=min(dp[i-1][1],dp[i-1][2])+cost[i-1][0];
    dp[i][1]=min(dp[i-1][0],dp[i-1][2])+cost[i-1][1];
    dp[i][2]=min(dp[i-1][0],dp[i-1][1])+cost[i-1][2];
  }

  int ans[3];
  ans[0]=dp[n][0];
  ans[1]=dp[n][1];
  ans[2]=dp[n][2];
  sort(ans,ans+3);
  cout<<ans[0];
}