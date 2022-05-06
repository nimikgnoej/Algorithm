#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n;
int cnt[100001];
vector<pair<int,int>> v;

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n;
  fill(cnt,cnt+n,1);
  for(int i=0;i<n;i++){
    int start,fin;
    cin>>start>>fin;
    v.push_back(make_pair(fin,start));
  }

  sort(v.begin(),v.end());
  

  int count=1;
  int time=v[0].first;
  for(int i=1;i<n;i++){
    if(time<=v[i].second){
      count++;
      time=v[i].first;
    }
  }

  cout<<count;
}