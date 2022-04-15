#include <iostream>
#include <algorithm>
using namespace std;

int dp[301];
int score[301];

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  cin>>n;
  for(int i=1;i<=n;i++){
    cin>>score[i];
  }

  dp[1]=score[1];
  dp[2]=score[1]+score[2];

  for(int i=3;i<=n;i++){
    dp[i]=max(dp[i-2]+score[i],dp[i-3]+score[i-1]+score[i]);
  }

  cout<<dp[n]<<'\n';
} 