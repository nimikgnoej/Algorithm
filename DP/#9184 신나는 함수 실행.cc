#include <iostream>
using namespace std;

int memo[51][51][51];

int w(int a,int b,int c){
  if(a<=0 || b<=0 || c<=0)
    return 1;
    
  else if(a>20 || b>20 || c>20)
    return w(20,20,20);
    
  else if(a<b && b<c){
    if(memo[a][b][c]!=0)
      return memo[a][b][c];
    else if(memo[a][b][c]==0){
      memo[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
      return memo[a][b][c];
    }
  }

  else{
    if(memo[a][b][c]!=0)
      return memo[a][b][c];
    else if(memo[a][b][c]==0){
      memo[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
      return memo[a][b][c];
    }
  }
}

int main()
{
  //freopen("input.txt","r",stdin);
  int a,b,c;
  int ans=0;
  while(true){
    cin>>a>>b>>c;
    if(a==b&&b==c && a==-1){
      break;
    }
    else{
      ans=w(a,b,c);
      cout<<"w("<<a<<", "<<b<<", "<<c<<") = "<<ans<<'\n';
    }
  }
}