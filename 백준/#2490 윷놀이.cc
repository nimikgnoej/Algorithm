#include <iostream>
#include <string>
using namespace std;

int main()
{
  int a,b,c,d;
  for(int i=0;i<3;i++){
      cin>>a>>b>>c>>d;
    if(a+b+c+d==1)
      cout<<"C"<<'\n';
    else if(a+b+c+d==2)
      cout<<"B"<<'\n';
    else if(a+b+c+d==3)
      cout<<"A"<<'\n';
    else if(a+b+c+d==4)
      cout<<"E"<<'\n';
    else if(a+b+c+d==0)
      cout<<"D"<<'\n';
  }
}