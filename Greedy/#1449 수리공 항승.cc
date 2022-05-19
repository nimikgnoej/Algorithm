#include <iostream>
#include <algorithm>
using namespace std;

int pipe[1001];

int main()
{
  //freopen("input.txt","r",stdin);
  int n,l;
  int tape=1;
  cin>>n>>l;

  if(l==1){
    cout<<n;
    return 0;
  }
  
  for(int i=0;i<n;i++)
    cin>>pipe[i];
  sort(pipe,pipe+n);

  int start=pipe[0];
  for(int i=1;i<n;i++){
    if(pipe[i]-start+1>l){
      tape++;
      start=pipe[i];
    }
  }

  cout<<tape;
}