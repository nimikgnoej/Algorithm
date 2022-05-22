#include <iostream>
#include <algorithm>
using namespace std;

int n;
int dp[2][100001];
int score[2][100001];

void clean(){
  for(int i=0;i<2;i++){
    for(int j=0;j<n;j++){
      dp[i][j]=0;
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  int t;
  cin>>t;
  while(t--){
    clean();
    cin>>n;
    for(int i=0;i<2;i++){
      for(int j=0;j<n;j++){
        cin>>score[i][j];
      }
    }
    dp[0][1]=score[0][0];
    dp[1][1]=score[1][0];
    dp[0][2]=score[0][1]+score[1][0];
    dp[1][2]=score[1][1]+score[0][0];
    for(int k=3;k<=n;k++){
      dp[1][k]=max(dp[0][k-1],max(dp[1][k-2],dp[0][k-2]))+score[1][k-1];
      dp[0][k]=max(dp[1][k-1],max(dp[0][k-2],dp[1][k-2]))+score[0][k-1];
    }
    cout<<max(dp[0][n],dp[1][n])<<'\n';
  }
}