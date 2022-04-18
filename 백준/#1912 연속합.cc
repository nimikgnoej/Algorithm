#include <iostream>
#include <algorithm>
using namespace std;

int n;
int dp[100001];
int arr[100001];

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n;
  for(int i=0;i<n;i++){
    cin>>arr[i];
  }
  dp[0]=arr[0];
  int res=dp[0];

  for(int i=1;i<n;i++){
    dp[i]=max(dp[i-1]+arr[i],arr[i]);
    res=max(res,dp[i]);
  }

  cout<<res;
}