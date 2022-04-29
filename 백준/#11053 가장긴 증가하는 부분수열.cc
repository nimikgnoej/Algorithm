#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,cnt;
int seq[1001];
int dp[1001];

int main()
{
  //freopen("input.txt","r",stdin);
  cnt=1;
  cin>>n;
  for(int i=0;i<n;i++)
    cin>>seq[i];

  for(int i=0;i<n;i++){
    dp[i]=1;
    for(int j=0;j<n;j++){
      if(seq[j]<seq[i] && dp[i]<dp[j]+1){
        dp[i]=dp[j]+1;
      }
    }
  }

  sort(dp,dp+n);
  cout<<dp[n-1];
}