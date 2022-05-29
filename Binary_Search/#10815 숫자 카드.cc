#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> elec;
vector<int> target;

int bin_search(vector<int>& copy,int start,int target,int end){
  while(true){
    if(start>end)
      return -1;
    int mid=(start+end)/2;
    if(copy[mid]>target){
      end=mid-1;
    }
    else if(copy[mid]<target)
      start=mid+1;
    else if(copy[mid]==target){
      return mid;
    }
  }
}

int main() {
  //freopen("input.txt","r",stdin);
  int n,m;
  cin>>n;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    elec.push_back(num);
  }
  cin>>m;
  for(int i=0;i<m;i++){
    int num;
    cin>>num;
    target.push_back(num);
  }

  sort(elec.begin(),elec.end());
  for(int i=0;i<m;i++){
    if(bin_search(elec,0,target[i],n-1)==-1)
      cout<<"0"<<" ";
    else
      cout<<"1"<<" ";
  }
}