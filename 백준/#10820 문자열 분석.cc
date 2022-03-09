#include <iostream>
#include <string>
using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  string str;
  while(getline(cin,str)){
    int small=0,big=0,space=0,num=0;

    for(int i=0;i<str.size();i++){
      if(str[i]>=65&&str[i]<=90)
        big++;
      else if(str[i]>=97&&str[i]<=122)
        small++;
      else if(str[i]==' ')
        space++;
      else if(str[i]>=48&&str[i]<=57)
        num++;
    }

    cout<<small<<" "<<big<<" "<<num<<" "<<space<<'\n';
  }
}