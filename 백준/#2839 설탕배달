#include <iostream>

using namespace std;

int N;
int main() {
	cin >> N;
	int ans = 0;
	while (N>=0) {
		if (N % 5 == 0) {	//가장 큰 수로 나누는게 가장 작은수랑 섞어서 나누는 것보다 유리
			ans += (N / 5);	//나눈 몫을 더한 것이 정답
			cout << ans << endl;
			return 0;
		}
		N -= 3;	//3kg을 빼고 
		ans++;	//가방 하나 늘어남
	}
	cout << -1 << endl;
}
