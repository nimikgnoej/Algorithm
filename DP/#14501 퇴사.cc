#include <iostream>
#include <algorithm>
using namespace std;

int P[16];
int T[16];
int dp[16];
int n;

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n;
  for(int i=1;i<=n;i++)
    cin>>T[i]>>P[i];

  for(int i=n;i>=1;i--){
    if(n+1-i < T[i])
      dp[i]=dp[i+1];
    else if(n+1-i >= T[i]){
      dp[i]=max(dp[i+T[i]]+P[i],dp[i+1]);
    }
  }

  cout<<dp[1];
}