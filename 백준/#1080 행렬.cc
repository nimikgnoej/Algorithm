#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n,m;
int mata[51][51];
int matb[51][51];

void matrixChange(int x,int y){
  for(int i=x;i<=x+2;i++){
    for(int j=y;j<=y+2;j++){
      mata[i][j]=1-mata[i][j];
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>m;
  int cnt=0;
  
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      scanf("%1d",&mata[i][j]);
    }
  }
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      scanf("%1d",&matb[i][j]);
    }
  }

  for(int i=0;i<=n-3;i++){
    for(int j=0;j<=m-3;j++){
      if(mata[i][j]!=matb[i][j]){
        matrixChange(i,j);
        cnt++;
      }
    }
  }

  bool flag=false;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(mata[i][j]!=matb[i][j]){
        cnt=-1;
        flag=true;
        break;
      }
    }
    if(flag==true)
      break;
  }
  cout<<cnt;
}