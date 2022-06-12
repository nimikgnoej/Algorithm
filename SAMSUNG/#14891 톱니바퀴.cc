#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

bool check[5];
vector<int> wheel[5];

void solve(int num,int dir);

void print(){
  for(int i=1;i<5;i++){
    for(int j=0;j<8;j++){
      cout<<wheel[i][j]<<" ";
    }
    cout<<'\n';
  }
}

void clear(){
  for(int i=0;i<5;i++){
    check[i]=false;
  }
}

void rotate_wheel(int num,int dir){
  check[num]=true; //num번째 휠은 돌았다
  if(dir==1){ //시계방향으로 돌릴때
    int save=wheel[num][7];
    for(int i=6;i>=0;i--){
      wheel[num][i+1]=wheel[num][i];
    }  
    wheel[num][0]=save;
  }

  else if(dir==-1){ //반시계 방향으로 돌릴때
    int save=wheel[num][0];
    for(int i=1;i<8;i++){
      wheel[num][i-1]=wheel[num][i];
    }
    wheel[num][7]=save;
  }
  solve(num,dir);
}

void solve(int num,int dir){
  if(num==1){
    if(dir==1){ //시계방향으로 돌았고
      if(wheel[num][3]!=wheel[num+1][6]){ //극이 다르고
        if(check[num+1]==false) //num+1번째 휠이 아직 안돌았다면
          rotate_wheel(num+1,-dir); //2번 휠을 반시계로 돌림
      }
    }
    else if(dir==-1){ //반시계로 돌았고
      if(wheel[num][1]!=wheel[num+1][6]){ //극이 다르고
        if(check[num+1]==false)        
          rotate_wheel(num+1,-dir); //2번 휠을 시계로 돌림
      }
    }
  }

  else if(num==2 || num==3){
    if(dir==1){
      if(wheel[num][7]!=wheel[num-1][2]){
        if(check[num-1]==false)
          rotate_wheel(num-1,-dir);
      }
      if(wheel[num][3]!=wheel[num+1][6]){
        if(check[num+1]==false)
          rotate_wheel(num+1,-dir);
      }
    }
    else if(dir==-1){
      if(wheel[num][5]!=wheel[num-1][2]){
        if(check[num-1]==false)
          rotate_wheel(num-1,-dir);
      }
      if(wheel[num][1]!=wheel[num+1][6]){
        if(check[num+1]==false)
          rotate_wheel(num+1,-dir);
      }
    }
  }

  else if(num==4){
    if(dir==1){
      if(wheel[num][7]!=wheel[num-1][2]){
        if(check[num-1]==false)
          rotate_wheel(num-1,-dir);
      }
    }
    else if(dir==-1){
      if(wheel[num][5]!=wheel[num-1][2]){
        if(check[num-1]==false)
          rotate_wheel(num-1,-dir);
      }
    }
  }
}

int cal(){
  int sum=0;
  for(int i=1;i<5;i++){
    if(wheel[i][0]==1)
      sum+=pow(2,i-1);
  }
  return sum;
}

int main()
{
  //freopen("input.txt","r",stdin);
  int k; //돌릴 횟수 k
  for(int i=1;i<5;i++){
    string input;
    cin>>input;
    for(int j=0;j<8;j++){
      wheel[i].push_back(input[j]-'0');
    }
  }
  cin>>k;
  while(k--){
    clear();
    int num,dir;
    cin>>num>>dir;
    rotate_wheel(num,dir);
  }
  cout<<cal();
}