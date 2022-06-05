#include <iostream>
#include <algorithm>
using namespace std;

int dp[10001];
int cost[101];

int main()
{
  //freopen("input.txt","r",stdin);
  int n,k;
  cin>>n>>k;
  for(int i=1;i<=n;i++)
    cin>>cost[i];

  dp[0]=1;
  for(int i=1;i<=n;i++){
    for(int j=cost[i];j<=k;j++){
      dp[j]=dp[j]+dp[j-cost[i]];
    }
  }

  cout<<dp[k];
}