#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> house;

int main()
{
  //freopen("input.txt","r",stdin);
  int n;
  int ans=0;
  cin>>n;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    house.push_back(num);
  }
  sort(house.begin(),house.end());
  ans=house[(n-1)/2];
  cout<<ans;
}