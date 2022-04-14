#include <iostream>
#include <vector>
using namespace std;

vector<int> memo(1000000);

int go(int n){
  if(n==1)
    return 0;
  if(memo[n]!=0)         //메모이제이션
    return memo[n];
  memo[n]=go(n-1)+1;

  if(n%2==0){
    int temp = go(n/2)+1;
    if(memo[n]>temp)
      memo[n]=temp;
  }

  if(n%3==0){
    int temp = go(n/3)+1;
    if(memo[n]>temp)
      memo[n]=temp;
  }

  return memo[n];
}

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  cin>>n;
  cout<<go(n)<<'\n';
}