#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

int r,c,t;
int clockwise,counter;
int map[51][51];
int new_map[51][51];
int dx[]={0,1,0,-1};
int dy[]={1,0,-1,0};

void ready_to_dif(){
  for(int i=1;i<=r;i++){
    for(int j=1;j<=c;j++){
      if(map[i][j]>=5)
        new_map[i][j]=map[i][j]/5;
    }
  }
}

void diffusion(){
  for(int i=1;i<=r;i++){
    for(int j=1;j<=c;j++){
      int cnt=0;
      if(map[i][j]>=5){
        for(int k=0;k<4;k++){
          int nx=i+dx[k];
          int ny=j+dy[k];
          if(nx<1 || ny<1 || nx>r || ny>c) continue;
          if(map[nx][ny]==-1) continue;
          map[nx][ny]+=new_map[i][j];
          cnt++;
        }
        if(map[i][j]-new_map[i][j]*cnt>=0)
          map[i][j]=map[i][j]-new_map[i][j]*cnt;
        else
          map[i][j]=0;
      }
    }
  }
}

void find_cleaner(){
  bool flag=false;
  for(int i=1;i<=r;i++){
    for(int j=1;j<=c;j++){
      if(map[i][j]==-1){
        counter=i;
        flag=true;
        break;
      }
    }
    if(flag==true)
      break;
  }
  clockwise=counter+1;
}

void wind(){
  int save1,save2,save3,save4;
  save1=map[counter][c];
  save2=map[1][1];
  save3=map[clockwise][c];
  save4=map[r][1];
  
  for(int i=1;i<c;i++){ //첫번째 행은 항상 반시계
    map[1][i]=map[1][i+1];
  }
  for(int i=c;i>=3;i--){ //반시계 방향
    map[counter][i]=map[counter][i-1];
  }
  map[counter][2]=0; //항상 좋은 공기 이므로

  for(int i=1;i<c;i++){ //마지막 행은 항상 시계방향
    map[r][i]=map[r][i+1];
  }
  for(int i=c;i>=3;i--){ //시계방향
    map[clockwise][i]=map[clockwise][i-1];
  }
  map[clockwise][2]=0;

  for(int i=1;i<counter-1;i++){
    map[i][c]=map[i+1][c];
  }
  map[counter-1][c]=save1;
  for(int i=r;i>clockwise;i--){
    map[i][c]=map[i-1][c];
  }
  map[clockwise+1][c]=save3;
  for(int i=counter-1;i>2;i--){
    map[i][1]=map[i-1][1];
  }
  map[2][1]=save2;

  for(int i=clockwise+1;i<r-1;i++){
    map[i][1]=map[i+1][1];
  }
  map[r-1][1]=save4;
}

void solve(){
  int sum=0;
  for(int i=1;i<=r;i++){
    for(int j=1;j<=c;j++){
      if(map[i][j]!=-1)
        sum+=map[i][j];
    }
  }

  cout<<sum;
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>r>>c>>t;
  for(int i=1;i<=r;i++){
    for(int j=1;j<=c;j++){
      cin>>map[i][j];  
    }
  }

  for(int i=0;i<t;i++){
    memset(new_map,0,sizeof(new_map));
    ready_to_dif();
    diffusion();
    
    find_cleaner();
    wind();
  }
  solve();
}