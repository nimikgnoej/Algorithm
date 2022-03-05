#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
  int n;
  cin>>n;
  vector<vector <int>> p(n,vector<int>(2,0));
  vector<int> v;
  
  for(int i=0;i<n;i++){
    cin>>p[i][0];
    cin>>p[i][1];
  }
  sort(p.begin(),p.end());

  for(int j=0;j<p.size();j++){
    cout<<p[j][0]<<" "<<p[j][1]<<'\n';
  }
}