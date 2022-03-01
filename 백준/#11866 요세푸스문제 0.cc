#include <iostream>
#include <queue>
using namespace std;

int main()
{
  queue<int> v;
  int n,k;
  int check=1;
  
  cin>>n>>k;
  
  for(int i=0;i<n;i++){
    v.push(i+1);
  }
  cout<<"<";
  while(!v.empty()){
    if(check!=k){
      v.push(v.front());
      v.pop();
      check++;
    }
    else{
      if(v.size()==1)
        cout<<v.front();
      else
        cout<<v.front()<<", ";
      v.pop();
      check=1;
    }
  }
  cout<<">"<<'\n';
}