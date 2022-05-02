#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int P[10002];
int dp[1001];

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  cin>>n;
  for(int i=1;i<=n;i++){
    cin>>P[i];
  }

  for(int i=1;i<=n;i++){
    dp[i]=0;
    for(int j=1;j<=i;j++){
      int x=P[j];
      if(dp[i]<dp[i-j]+x)
        dp[i]=dp[i-j]+x;
    }
  }

  cout<<dp[n];
}