#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int dp[1001][1001]; // 최대 1000자
string a,b;

int main() {

    cin >> a >> b;// string 값 입력
    
    //dp 구현
    for(int i=1; i<=a.size(); i++){
        for(int j=1; j<=b.size(); j++){
            if(a[i-1] != b[j-1]){
                dp[i][j] = max(dp[i-1][j] , dp[i][j-1]);
            }
            else if(a[i-1] == b[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1;
            }
        }
    }
    
   cout << dp[a.size()][b.size()] <<'\n';

    return 0;
}