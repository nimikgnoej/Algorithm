#include <iostream>
using namespace std;

int main()
{
  int n;
  cin>>n;
  int count;
  int targetH,targetW;
  int height[n];
  int weight[n];
  int rank[n];
  
  for(int i=0;i<n;i++){
    cin>>height[i]>>weight[i];
  }


  for(int j=0;j<n;j++){
    count=0;
    targetH=height[j];
    targetW=weight[j];
    for(int x=0;x<n;x++){
      if(targetH<height[x]&&targetW<weight[x])
        count++;
    }
    rank[j]=count+1;
  }

  for(int k=0;k<n;k++){
    cout<<rank[k]<<' ';
  }
}