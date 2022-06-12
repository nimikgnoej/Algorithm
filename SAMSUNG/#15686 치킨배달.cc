#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstdlib>
#define INF 1e9
using namespace std;

int n,m,res;
int _min=INF;
int map[51][51];
int chickvisit[51][51];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};
vector<int> chick,tmp;
vector<pair<int,int>> house,ch;

int dist(int a,int b,int c,int d){
  return abs(a-c)+abs(b-d);
}


int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>m;
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      cin>>map[i][j];
      if(map[i][j]==1) house.push_back({i,j});
      if(map[i][j]==2) ch.push_back({i,j});
    }
  }

  for(int i=0;i<m;i++) tmp.push_back(1);
  for(int i=m;i<ch.size();i++) tmp.push_back(0);

  do{
    vector<pair<int,int>> best;
    res=0;
    for(int i=0;i<ch.size();i++){
      if(tmp[i]==1)
        best.push_back({ch[i].first,ch[i].second});
    }
      for (int i = 0; i < house.size(); i++) {	//치킨 거리 구하기
        int len, min_len = INF;
        int x = house[i].first, y = house[i].second;
        for (int j = 0; j < m; j++) {
          len = abs(best[j].first - x) + abs(best[j].second - y);
          min_len = min(min_len, len);
        }
        res += min_len;
      }
    _min = min(_min, res);
  }while(prev_permutation(tmp.begin(),tmp.end()));
  cout<<_min;
}