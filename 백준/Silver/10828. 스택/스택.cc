#include <iostream>
#include <string>
using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int stack[10000];
  int size=0;
  int n;
  string str;
  cin>>n;
  while(n--){
    cin>>str;
    if(str=="push"){
      int num;
      cin>>num;
      stack[size]=num;
      size++;
    }
    else if(str=="pop"){
      if(size==0)
        cout<<"-1"<<'\n';
      else{
        cout<<stack[size-1]<<'\n';
        size--;
      }
    }
    else if(str=="size"){
      cout<<size<<'\n';
    }
    else if(str=="empty"){
      if(size==0)
        cout<<"1"<<'\n';
      else
        cout<<"0"<<'\n';
    }
    else if(str=="top"){
      if(size==0)
        cout<<"-1"<<'\n';
      else
        cout<<stack[size-1]<<'\n';
    }
  }
}