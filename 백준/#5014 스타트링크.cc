#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int F,G,S,U,D;
queue<int> q;
vector<int> visited(1000001); //방문 기록
vector<int> dist(1000001,-1); //버튼 누른횟수 -1로 초기화 해둠

void bfs(int x){
  q.push(x);
  visited[x]=1;
  dist[x]=0;
  while(!q.empty()){
    int now=q.front();
    q.pop();

    if(now==G){ //목적지에 도착하면 break
      break;
    }
    
    if(now+U<=F && visited[now+U]==0){ //위로 올라갈 수 있을때
      q.push(now+U);
      visited[now+U]=1;
      dist[now+U]=dist[now]+1;
    }
    if(now-D>0 && visited[now-D]==0){  //아래로 내려갈 수 있을때
      q.push(now-D);
      visited[now-D]=1;
      dist[now-D]=dist[now]+1;
    }
  }
}

int main()
{

  cin>>F>>S>>G>>U>>D; //목적지는 G이고 현재위치는 S  
  bfs(S);
  if(dist[G]==-1)
    cout<<"use the stairs"<<'\n';
  else if(visited[G]==1)
    cout<<dist[G]<<'\n';
}