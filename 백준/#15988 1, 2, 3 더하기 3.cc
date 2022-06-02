#include <iostream>
#include <algorithm>
#include <vector>
#define MAX 1000000
#define MOD 1000000009
using namespace std;

long long dp[MAX+1];

int main()
{
  //freopen("input.txt","r",stdin);
  int t;
  cin>>t;
  dp[1]=1;
  dp[2]=2;
  dp[3]=4;
  while(t--){
    int n;
    cin>>n;
    for(int i=4;i<=n;i++)
      dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%MOD;
    cout<<dp[n]%MOD<<'\n';
  }
}