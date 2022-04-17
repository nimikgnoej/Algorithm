#include <iostream>
#include <algorithm>
#define mod 10007
using namespace std;

int n,l;
long long cnt;
long long dp[1001][11];

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n;
  for(int i=0;i<=9;i++){
    dp[1][i]=1;
  }

  for(int i=2;i<=n;i++){
    for(int j=0;j<=9;j++){
      dp[i][j]=dp[i-1][j]%mod;
      for(int k=1;k<=j;k++){
        dp[i][j]=(dp[i][j] + dp[i-1][j-k])%mod;
      }
    }
  }
  

  for(int i=0;i<=9;i++){
    cnt+=dp[n][i];
  }

  cout<<cnt%mod<<'\n';
}