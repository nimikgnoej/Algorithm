#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  long long sum=0;
  vector<int> expect;
  cin>>n;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    expect.push_back(num);
  }
  sort(expect.begin(),expect.end());

  for(int i=1;i<=n;i++){
    if(expect[i-1]>=i)
      sum+=(expect[i-1]-i);
    else
      sum+=(i-expect[i-1]);
  }
  cout<<sum;
}