#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int Lcs(string& a, string& b);
int dp[2][1001]; // 최대 1000자 + 1 (0번 인덱스 처리 포함)
string a, b;

int main() {
    cin >> a >> b; // 문자열 입력
    
    int result = Lcs(a,b);
    cout << result;
    return 0;
}

int Lcs(string& a, string& b)
{
    int asize = a.size();
    int bsize = b.size();
    // dp 테이블 채우기
    for (int i = 1; i <= a.size(); i++) {
        for (int j = 1; j <= b.size(); j++) {
            if (a[i - 1] == b[j - 1]) { // 문자열은 0-based 접근
                dp[i%2][j] = dp[(i+1)%2][j - 1] + 1; // 문자가 같을 때
            } else {
                dp[i%2][j] = max(dp[i%2][j-1], dp[(i+1)%2][j]); // 문자가 다를 때
            }
        }
    }
    return dp[asize%2][bsize];
}