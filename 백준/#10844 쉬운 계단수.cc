#include <iostream>
#include <algorithm>
#define MAX 1000000000
using namespace std;

long long dp[101][11];
long long cnt;

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  int l;
  cin>>n;
  for(int i=1;i<=9;i++){  
    dp[1][i]=1; 
  }

  for(int i=2;i<=n;i++){
    for(int j=0;j<10;j++){
      if(j==0){
        dp[i][j]=dp[i-1][j+1]%MAX;
      }
      else if(j==9){
        dp[i][j]=dp[i-1][j-1]%MAX;
      }
      else{
        dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%MAX; 
      }
    }
  }
  
  for(int i=0;i<=9;i++){
    cnt=cnt+dp[n][i];
  }
  cout<<cnt%MAX<<'\n';
}