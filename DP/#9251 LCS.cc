#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int dp[1001][1001];

int main()
{
  //freopen("input.txt","r",stdin);
  string str1,str2;
  cin>>str1;
  cin>>str2;
  for(int i=1;i<=str2.size();i++){
    for(int j=1;j<=str1.size();j++){
      if(str1[j-1]==str2[i-1]){
        dp[i][j]=dp[i-1][j-1]+1;
      }
      else
        dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
    }
  }
  cout<<dp[str2.size()][str1.size()];
}