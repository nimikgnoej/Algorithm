#include <iostream>
using namespace std;

int l,p,v;

int main()
{
  //freopen("input.txt","r",stdin);
  int ans=0;
  int i=0;
  while(true){
    ans=0;
    i++;
    cin>>l>>p>>v;
    if(l==p&&p==v&&p==0)
      break;
    while(true){
      if(v==0)
        break;
      if(v-p>=0){
        v-=p;
        ans+=l;
      }
      else if(v-p<0){
        if(v>l)
          ans+=l;
        else
          ans+=v;
        v=0;
      }
    }
    cout<<"Case "<<i<<": "<<ans<<'\n';
  }
}