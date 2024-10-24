#include <iostream>
#include <deque>
#include <algorithm>

using namespace std;

int dp[100001];
int xs, xe;

int main() {
    cin >> xs >> xe;
    fill(dp, dp + 100001, 100001);  
    dp[xs] = 0;  

    deque<int> dq;
    dq.push_back(xs);

    while (!dq.empty()) {
        int x = dq.front();
        dq.pop_front();

        // 걷기: x-1로 이동 
        if (x - 1 >= 0 && dp[x - 1] > dp[x] + 1) {
            dp[x - 1] = dp[x] + 1;
            dq.push_back(x - 1); 
        }

        // 걷기: x+1로 이동 
        if (x + 1 < 100001 && dp[x + 1] > dp[x] + 1) {
            dp[x + 1] = dp[x] + 1;
            dq.push_back(x + 1);  
        }

        // 순간이동: 2*x로 이동 
        if (2 * x < 100001 && dp[2 * x] > dp[x]) {
            dp[2 * x] = dp[x]; 
            dq.push_front(2 * x);  
        }
    }

    cout << dp[xe] << '\n';
    return 0;
}
