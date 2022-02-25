#include <iostream>
#include <stack>
using namespace std;

int main()
{
  int k;
  int num;
  int sum=0;
  stack<int> s;
  cin>>k;

  while(k--){
    cin>>num;
    if(num==0)
      s.pop();
    else
      s.push(num);
  }

  while(!s.empty()){
    sum+=s.top();
    s.pop();
  }
  cout<<sum<<'\n';
}