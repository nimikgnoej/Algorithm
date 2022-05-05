#include <iostream>
#include <algorithm>
using namespace std;

int A[11];
int n,k,cnt;

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>k;

  for(int i=0;i<n;i++){
    cin>>A[i];
  }

  while(true){
    if(k==0)
      break;
    for(int i=n-1;i>=0;i--){
      if(k-A[i]>=0){
        k-=A[i];
        cnt++;
        break;
      }
    }
  }
  cout<<cnt;
}