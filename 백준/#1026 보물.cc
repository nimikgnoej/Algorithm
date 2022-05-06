#include <iostream>
#include <algorithm>
using namespace std;

int A[51];
int B[51];

bool comp(int a,int b){
  return b<a;
}

int main(){
  //freopen("input.txt","r",stdin);
  int n;
  cin>>n;
  for(int i=0;i<n;i++)
    cin>>A[i];
  for(int i=0;i<n;i++)
    cin>>B[i];

  sort(A,A+n);
  sort(B,B+n,comp);

  int res=0;
  for(int i=0;i<n;i++){
    int ans;
    ans=A[i]*B[i];
    res+=ans;
  }

  cout<<res;
}
