#include <iostream>
#include <string>
using namespace std;

int main()
{
  int alpha[26]={0, };

  string str;
  getline(cin,str);

  for(int i=0;i<str.length();i++)
  {
    alpha[str[i]-'a']++;
  }

  for(int j=0;j<26;j++)
    cout<<alpha[j]<<' ';
}