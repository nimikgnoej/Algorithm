#include <iostream>
using namespace std;

int memo[41];
int cntone;
int cntzero;

int fibo(int n){
  if(n==0){
    cntzero++;
    return 0;
  }
  else if(n==1){
    cntone++;
    return 1;
  }
  else if(memo[n]!=0){
    return memo[n];
  }
  else{
    memo[n]=fibo(n-1)+fibo(n-2);
    return memo[n];
  }
    
}

int main()
{
  //freopen("input.txt","r",stdin);
  int T,N,some;
  cin>>T;
  while(T--){
    cntone=0;
    cntzero=0;
    cin>>N;
    some=fibo(N);

    if(N>=2){
      cout<<fibo(N-1)<<" "<<fibo(N)<<'\n';
    }
    else{
      cout<<cntzero<<" "<<cntone<<'\n';
    }
  }
}