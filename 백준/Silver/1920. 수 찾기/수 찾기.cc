#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main () {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n, temp;
    vector<int> v;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> temp;
        v.push_back(temp);
    }
    sort(v.begin(), v.end());
    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> temp;
        cout << binary_search(v.begin(), v.end(), temp) << '\n';
    }
}