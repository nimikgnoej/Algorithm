#include <iostream>
#include <string>
using namespace std;

int main()
{
  string str;
  cin>>str;

  for(int i=0;i<str.size();i++){
    if('a'-str[i]<=32&&'a'-str[i]>0)
      cout<<str[i];
  }
}
