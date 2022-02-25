#include <iostream>
using namespace std;

int factorial(int num)
{
  if(num==0)
    return 1;
  else if(num==1)
    return 1;
  else
    return factorial(num-1)*num;
}

int main()
{
  int n,k;
  int ans=0;
  cin>>n>>k;

  ans= factorial(n)/(factorial(k)*factorial(n-k));

  cout<<ans<<'\n';
}