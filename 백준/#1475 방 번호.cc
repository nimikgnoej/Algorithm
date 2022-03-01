#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
  string room;
  vector<int> arr(10);
  int idx;
  cin>>room;

  for(int i=0;i<room.size();i++){
    arr[room[i]-'0']++;
  }

  int num=0;
  for(int i=0; i< 10; i++){
      if(i!=9 && i!=6) num = max(num, arr[i]);
  }
    
  cout << max(num, (arr[6] + arr[9] + 1) /2);
  return 0;
}