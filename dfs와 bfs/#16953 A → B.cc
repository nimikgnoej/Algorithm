#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define MAX 100000001
using namespace std;

int a,b;
queue<pair<long long,int>> q;

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>a>>b;
  int ans=-1;
  q.push(make_pair(a,1));
  while(!q.empty()){
    long long x=q.front().first;
    int cnt=q.front().second;
    q.pop();

    if(x==b){
      ans=cnt;
      break;
    }
    if(2*x<=b)
      q.push(make_pair(2*x,cnt+1));
    if(10*x+1<=b)
      q.push(make_pair(10*x+1,cnt+1));
  }
  cout<<ans;
}