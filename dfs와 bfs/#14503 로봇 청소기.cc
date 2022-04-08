#include<iostream>


using namespace std;

int n, m;
int map[51][51];

int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };

int ans;

void dfs(int cx, int cy, int cd) {
	if (map[cx][cy] == 0) {
		map[cx][cy] = 2;
		ans++;
	}

	for (int i = 0; i < 4; i++) {
		int nd = (cd + 3 - i) % 4;
		int nx = cx + dx[nd];
		int ny = cy + dy[nd];

		if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
			continue;
		}

		if (map[nx][ny] == 0) {
			dfs(nx, ny, nd);
		}
	}    

	int nd = (cd + 2) % 4;
	int nx = cx + dx[nd];
	int ny = cy + dy[nd];

	if (map[nx][ny] == 1) {
		cout << ans;
		exit(0);
	}
	dfs(nx, ny, cd); //바라보는 방향을 유지한채.....
}


int main(void) {
	cin >> n >> m;

	int r, c, dir;
	cin >> r >> c >> dir;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> map[i][j];
		}
	}

	dfs(r, c, dir);

	return 0;
}