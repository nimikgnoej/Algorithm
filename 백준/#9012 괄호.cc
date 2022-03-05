#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int t;
  cin>>t;
  while(t--){
    stack<char> s;
    bool flag=false;
    string str;
    cin>>str;
    for(int i=0;i<str.size();i++){
      if(str[i]=='(')
        s.push(str[i]);
      else if(str[i]==')'){
        if(s.empty()){
          flag=true;
          break;  
        }
        else
          s.pop();
      }
    }
    if(!s.empty())
      cout<<"NO"<<'\n';
    else if(s.empty()){
      if(flag==true)
        cout<<"NO"<<'\n';
      else
        cout<<"YES"<<'\n';
    }
  }
}