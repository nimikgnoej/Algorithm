#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> pack;
vector<int> nat;

int main()
{
  //freopen("input.txt","r",stdin);
  int n,m;
  int pack_num=0;
  cin>>n>>m;
  for(int i=0;i<m;i++){
    int panum,nanum;
    cin>>panum>>nanum;
    pack.push_back(panum);
    nat.push_back(nanum);
  }

  sort(pack.begin(),pack.end());
  sort(nat.begin(),nat.end());
  int mini;
  mini=n*nat[0];

  if(n<=6){
    if(mini>pack[0])
      mini=pack[0];
  }
  else{
    while(true){
      if(n<6){
        n=0;
        pack_num++;
        if(mini>pack.front()*pack_num)
          mini=pack.front()*pack_num;
        break;
      }
      n-=6;
      pack_num++;
      if(mini>pack.front()*pack_num+nat.front()*n)
        mini=pack.front()*pack_num+nat.front()*n;
    }
  }
  cout<<mini;
}