#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>
using namespace std;

int n,m; //nxn칸에서 ,m번 이동
int cloud_num;
int map[51][51];
int cloud_map[51][51];
int made[51][51];
int dx[]={0,-1,-1,-1,0,1,1,1};
int dy[]={-1,-1,0,1,1,1,0,-1};
queue<pair<int,int>> v;

void print(){
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      cout<<cloud_map[i][j]<<" ";
    }
    cout<<'\n';
  }
}

void print_map(){
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      cout<<map[i][j]<<" ";
    }
    cout<<'\n';
  }
}

void watering(){
  for(int i=1;i<=n;i++){ //비 내림
    for(int j=1;j<=n;j++){
      if(cloud_map[i][j]==1)
        map[i][j]+=1;
    }
  }
  for(int i=1;i<=n;i++){ //비 내림
    for(int j=1;j<=n;j++){
      if(cloud_map[i][j]==1){
        for(int k=1;k<8;k+=2){
          int nx=i+dx[k];
          int ny=j+dy[k];
          if(nx>=1 && nx<=n && ny>=1 && ny<=n){
            if(map[nx][ny]>0){
              map[i][j]++;
            }
          }
        }
      }
    }
  }
}

void select_cloud(){ //구름과 구름 개수를 초기화(비를내리고) 하고 새구름 생성
  for(int i=1;i<=n;i++){ //구름 초기화
    for(int j=1;j<=n;j++){
      cloud_map[i][j]=0;
    }
  }
  cloud_num=0;
  for(int i=1;i<=n;i++){ //새 구름 생성
    for(int j=1;j<=n;j++){
      if(made[i][j]==0){
        if(map[i][j]>=2){
          cloud_num++;
          map[i][j]-=2;
          cloud_map[i][j]=1;
        }
      }
    }
  }
  memset(made,0,sizeof(made));
}

void move_cloud(int dir,int sel){
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      if(cloud_map[i][j]==1){
        cloud_map[i][j]=0;
        int nx=i+(dx[dir-1]*sel);
        int ny=j+(dy[dir-1]*sel);
        while(nx<1||ny<1||nx>n||ny>n){
          if(nx<1)
            nx+=n;
          if(nx>n)
            nx-=n;
          if(ny<1)
            ny+=n;
          if(ny>n)
            ny-=n;
        }
        v.push({nx,ny});
      }
    }
  }
  while(!v.empty()){
    int a=v.front().first;
    int b=v.front().second;
    v.pop();
    cloud_map[a][b]=1;
    made[a][b]=1;
  }
}

void rain(){
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      if(cloud_map[i][j]==1)
        map[i][j]+=1;
    }
  }
}

int sum(){
  int res=0;
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      res+=map[i][j];
    }
  }
  return res;
}

int main()
{
  //freopen("input.txt","r",stdin);
  cin>>n>>m;
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      cin>>map[i][j];
    }
  }
  cloud_map[n][1]=1;
  cloud_map[n-1][1]=1;
  cloud_map[n][2]=1;
  cloud_map[n-1][2]=1;
  
  while(m--){
    int d,s;
    cin>>d>>s;
    move_cloud(d,s); //구름 이동
    watering();
    select_cloud();    
  }
  cout<<sum();
}