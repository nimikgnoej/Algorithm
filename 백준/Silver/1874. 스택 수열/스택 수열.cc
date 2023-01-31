#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(){
  stack<int> s;
  string result;
  
  int n;
  cin >> n;

  int m = 0; //스택에 들어온 혹은 들어왔던 마지막 수
  int turn = 0; //이번에 뽑힌 수
  
  while(n--){
    cin >> turn;

    if(turn > m){ //ex.turn은 4인데 size는 0일때
      while(turn>m){
        s.push(++m);
        result += '+';
      }
      s.pop();
      result += '-';
    }
      
    else{ //ex. turn이 3인데 size가 4일때
      bool found = false;
      if(!s.empty()){
        int top = s.top();
        s.pop();
        result += '-';
        if(turn == top){ //turn<=m일 때는 스택의 top과 turn이 같을 때에만 가능함
          found = true;
        }
      }

      if(!found){ //ex. turn은 5인데 size는 7일때 -> 이런 경우는 수열을 만들 수 없음. 왜냐하면 문제에서 스택에서 뺄 때마다 수열을 만든다고 했음. 5를 만들기 위해선 6,7이 모두 빠져야 하므로 그래서 본인과 같은 수까지 밖에 할 수가 없음.
        cout << "NO" << '\n';
        return 0;
      }
    }  
  }

  for(auto x : result){
    cout << x << '\n';
  } 
  return 0;
}