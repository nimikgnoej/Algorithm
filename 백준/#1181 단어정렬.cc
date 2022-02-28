#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

bool compare(string a, string b)
{
  if(a.size()==b.size())
    return a<b;
  else
    return a.size()<b.size(); 
}

int main()
{
  int n;
  string target="";
  vector<string> strv;
  cin>>n;

  string str;
  for(int j=0;j<n;j++){
    cin>>str;
    strv.push_back(str);
  }
  sort(strv.begin(),strv.end(),compare);
  

  for(int i=0;i<strv.size();i++){
    if(target!=strv[i])
      cout<<strv[i]<<'\n';
    target=strv[i];
  }
}