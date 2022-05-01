#include <iostream>
#include <algorithm>
using namespace std;

int n,k;
int gachi[101];
int dp[10001];

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>k;
  for(int i=0;i<n;i++)
    cin>>gachi[i];

  for(int i=1;i<=k;i++){
    dp[i]=100001;
    for(int j=0;j<n;j++){
      int x=gachi[j];
      if(i-x>=0){
        if(dp[i]>dp[i-x]+1)
          dp[i]=dp[i-x]+1;
      }
    }
  }

  if(dp[k]!=100001)
    cout<<dp[k];
  else
    cout<<"-1";
}