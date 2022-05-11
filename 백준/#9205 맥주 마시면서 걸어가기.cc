#include<iostream>
#include<queue>
#include<vector>
#include<memory.h>
#include<math.h>
using namespace std;
const int MAX = 104;
 
int n, ans;
 
int check[MAX];
int arr[MAX][2];
queue <pair<int, int>> q;
 
void bfs() {
    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
 
        if (x == arr[n+1][0] && y == arr[n + 1][1]) {
            ans = 1;
            return;
        }
 
        int ny, nx;
        for (int i = 1; i < n + 2; i++) {
            nx = abs(x - arr[i][0]);
            ny = abs(y - arr[i][1]);
            if (check[i] == 0 && nx + ny <= 1000) {
                check[i] = 1;
                q.push(make_pair(arr[i][0], arr[i][1]));
            }
        }
    }
}
 
int main() {
    int t;
    cin >> t;
    for (int k = 0; k < t; k++) {
 
        while (!q.empty()) q.pop();
        memset(check, 0, sizeof(check));
        memset(arr, 0, sizeof(arr));
        ans = 0;
 
        cin >> n;
        for (int i = 0; i < n + 2; i++) {
            cin >> arr[i][0] >> arr[i][1];
        }
        q.push(make_pair(arr[0][0], arr[0][1]));
        bfs();
 
        if (ans == 1) cout << "happy" << "\n";
        else cout << "sad" << "\n";
 
    }
 
 
    return 0;
}