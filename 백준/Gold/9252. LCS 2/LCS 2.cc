#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int dp[1001][1001]; // 최대 1000자 + 1 (0번 인덱스 처리 포함)
string a, b;

int main() {
    cin >> a >> b; // 문자열 입력

    // dp 테이블 채우기
    for (int i = 1; i <= a.size(); i++) {
        for (int j = 1; j <= b.size(); j++) {
            if (a[i - 1] == b[j - 1]) { // 문자열은 0-based 접근
                dp[i][j] = dp[i - 1][j - 1] + 1; // 문자가 같을 때
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]); // 문자가 다를 때
            }
        }
    }

    cout << dp[a.size()][b.size()] << endl;
    
    int x = a.size();
    int y = b.size();
    string lcs = "";

    while (x > 0 && y > 0) {
        if (a[x - 1] == b[y - 1]) {
            lcs += a[x - 1]; //같으면 입력받음
            x--, y--; //대각선으로 이동
        }
        // 위쪽이 더 크면 위
        else if (dp[x - 1][y] >= dp[x][y - 1]) {
            x--;
        }
        // 왼쪽이 더 크면 왼쪽
        else {
            y--;
        }
    }
    
    reverse(lcs.begin(), lcs.end());
    
    cout << lcs << '\n';

    return 0;
}