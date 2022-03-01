#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

bool compare(int a,int b)
{
  return a>b;
}

int main()
{ 
  string a;
  int N;
  cin >> N;
  a = to_string(N);
  sort(a.begin(),a.end(),compare);
  cout << a;
}