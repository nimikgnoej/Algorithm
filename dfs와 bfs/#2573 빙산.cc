#include <cstdio>
#include <queue>
#include <cstring>
using namespace std;

int N, M;
int map[300][300];

void input() {
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &map[i][j]);
		}
	}
}

bool visited[300][300];

int xd[] = { 1, -1, 0,0 };
int yd[] = { 0, 0, 1, -1 };

void BFS(int i, int j) {
	queue <pair<int, int >> q;
	q.push({ i,j });
	visited[i][j] = true;

	while (!q.empty()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = y + yd[i];
			int nx = x + xd[i];
			if (ny < 0 || ny >= N)continue;
			if (nx < 0 || nx >= M) continue;
			if (visited[ny][nx])continue;

			if (map[ny][nx] == 0) { // 사방이 바닷물이면 ?
				map[y][x] = (map[y][x] == 0) ? 0 : map[y][x] - 1;
			}
			else { // 빙산이면 
				visited[ny][nx] = true;
				q.push({ ny,nx });
			}
		}
	}
}

int Solve() {
	int ans = 0;
	int ice = 0;
	for ( ; ; ans++) {
		ice = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && visited[i][j] == false) {
					BFS(i, j);
					ice++; // 빙산 개수 
				}
			}
		}
		if (ice >= 2) return ans;
		if (ice == 0) break;
		memset(visited, 0, sizeof(visited));
	}
	return 0;
}

int main() {
	input();
	printf("%d\n", Solve());
}