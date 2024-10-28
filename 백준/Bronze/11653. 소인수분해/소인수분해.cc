#include <iostream>
using namespace std;

int main()
{
  int num;
  cin>>num;

  if(num==1)
    return 0;
  
  for(int i=2;i<=num;i++)
  {
    while(num%i==0)
    {
      cout<<i<<'\n';
      num /= i;
    }
  }
}