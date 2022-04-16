#include <iostream>
#include <algorithm>
using namespace std;

int dp[501][501];
int triangle[501][501];

int main()
{
  //freopen("input.txt","r",stdin);
  int maxnum=0;
  int n; //삼각형의 크기
  cin>>n;

  for(int i=1;i<=n;i++){
    for(int j=1;j<=i;j++){
      cin>>triangle[i][j];
    }
  }

  dp[1][1]=triangle[1][1];
  //왼쪽
  for(int i=2;i<=n;i++){
    dp[i][1]=dp[i-1][1]+triangle[i][1];
  }

  //오른쪽
  for(int i=2;i<=n;i++){
    dp[i][i]=dp[i-1][i-1]+triangle[i][i];
  } 

  //이외
  for(int i=3;i<=n;i++){
    for(int j=2;j<n;j++){
      dp[i][j]=max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
    }
  }

  for(int i=1;i<=n;i++){
    if(dp[n][i]>maxnum)
      maxnum=dp[n][i];
  }

  cout<<maxnum<<'\n';
}