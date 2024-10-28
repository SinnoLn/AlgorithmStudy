#include <iostream>
#include <vector>

using namespace std;

int n, m;
vector<int> arr;
vector<vector<int>> dp;

void preprocess() {
    for (int i = 0; i < n; i++) {
        dp[i][i] = 1;
    }

    for (int i = 0; i < n - 1; i++) {
        if (arr[i] == arr[i + 1]) {
            dp[i][i + 1] = 1;
        }
    }

    for (int length = 3; length <= n; length++) {
        for (int i = 0; i <= n - length; i++) {
            int j = i + length - 1;
            if (arr[i] == arr[j] && dp[i + 1][j - 1] == 1) {
                dp[i][j] = 1;
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    arr.resize(n);
    dp.assign(n, vector<int>(n, 0));

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    preprocess();

    cin >> m;
    while (m--) {
        int s, e;
        cin >> s >> e;
        s--; e--; 
        cout << dp[s][e] << '\n';
    }

    return 0;
}