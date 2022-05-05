#include <iostream>
#include <algorithm>
using namespace std;

int P[1001];
int n,sum;

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n;
  for(int i=0;i<n;i++){
    cin>>P[i];
  }

  sort(P,P+n);

  for(int i=0;i<n;i++){
    for(int j=0;j<=i;j++){
      sum+=P[j];
    }
  }
  cout<<sum;
}