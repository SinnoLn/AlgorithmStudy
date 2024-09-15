#include <iostream>
#include <algorithm>
#include <climits>

using namespace std;

const int MAX = 50;
int result = INT_MAX;
char board[MAX][MAX];

int repaintCount(int x, int y) {
    int wf = 0; 
    int bf = 0; 

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if ((i + j) % 2 == 0) { 
                if (board[x + i][y + j] != 'W') wf++;
                if (board[x + i][y + j] != 'B') bf++;
            } else { 
                if (board[x + i][y + j] != 'B') wf++; 
                if (board[x + i][y + j] != 'W') bf++; 
            }
        }
    }
    return min(wf, bf);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
        }
    }

    for (int i = 0; i <= n - 8; i++) {
        for (int j = 0; j <= m - 8; j++) {
            result = min(result, repaintCount(i, j)); 
        }
    }

    cout << result << '\n'; 

    return 0;
}