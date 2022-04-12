#include <iostream>
#include <vector>
using namespace std;

long long memo[1000001];

int main()
{
  int N;
  cin>>N;
  memo[1]=1;
  memo[2]=2;

  for(int i=3;i<=N;i++){
    memo[i]=(memo[i-1]+memo[i-2])%15746;
  }

  cout<<memo[N];
}