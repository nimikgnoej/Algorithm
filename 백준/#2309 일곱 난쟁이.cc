#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  vector<int> v;
  int sum=0;

  for(int i=0;i<9;i++){
    int num;
    cin>>num;
    v.push_back(num);
    sum+=num;
  }
  sort(v.begin(),v.end());
  for(int j=0;j<v.size();j++){
    for(int k=0;k<v.size();k++){
      if(sum-v[j]-v[k]==100){
        for(int x=0;x<v.size();x++){
          if(v[x]==v[j] || v[x]==v[k])
            continue;
          cout<<v[x]<<'\n';
        }
        return 0;
      }
    }
  }
}