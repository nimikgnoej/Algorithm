#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
  //freopen("input.txt","r",stdin);
  long long s,n;
  cin>>s;

  int i=1;
  int res=0;
  long long sum=0;
  while(true){
    sum+=i;
    res++;
    if(sum>s){
      cout<<res-1;
      break;
    }
    i++;
  }
}