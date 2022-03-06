#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  
  queue<int> q;
  int n,k;
  int chk=1;
  cin>>n>>k;
  for(int i=0;i<n;i++){
    q.push(i+1);
  }
  cout<<"<";
  while(!q.empty()){
    for(int i=0;i<k-1;i++){
      q.push(q.front());
      q.pop();
    }
    cout<<q.front();
    q.pop();
    if(!q.empty())
      cout<<", ";
  }
  cout<<">";
}