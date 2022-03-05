#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  queue<int> q;
  string input; int n;
  cin>>n;
  
  while(n--){
    cin>>input;
    if(input=="push"){
      int num;
      cin>>num;
      q.push(num);
    }
    else if(input=="pop"){
      if(q.empty()){
        cout<<"-1"<<'\n';
      }
      else{
        cout<<q.front()<<'\n';
        q.pop();
      }
    }
    else if(input=="size"){
      cout<<q.size()<<'\n';
    }
    else if(input=="empty"){
      if(q.empty())
        cout<<"1"<<'\n';
      else
        cout<<"0"<<'\n';
    }
    else if(input=="front"){
      if(q.empty())
        cout<<"-1"<<'\n';
      else
        cout<<q.front()<<'\n';
    }
    else if(input=="back"){
      if(q.empty())
        cout<<"-1"<<'\n';
      else
        cout<<q.back()<<'\n';
    }
  }
}