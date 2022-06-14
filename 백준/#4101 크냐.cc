#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
  //freopen("input.txt","r",stdin);
  while(true){
    int a,b;
    cin>>a>>b;
    if(a==0&&b==0)
      break;
    if(a>b)
      cout<<"Yes"<<'\n';
    else
      cout<<"No"<<'\n';
  }
}