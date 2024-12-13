#include <iostream>
#include <vector>
#include <algorithm>
#define ITEM_SIZE 101
#define LIMIT 100001
using namespace std;

int n, k, w, v;

//1번부터 n번까지의 아이템을 사용하여 정확히 무게가 m이 되는 경우
vector<pair<int,int>> items;
int dp[ITEM_SIZE][LIMIT];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> k;
    //각 물건의 무게와 가치 파악
    for(int i=0; i<n; i++){
        cin >> w >> v;
        items.push_back({w,v});
    }
    
    //DP를 사용 (담는다, 담지 않는다)
    //가방의 크기 기준으로 dp넣기
    for(int i=1; i<=n; i++){ //아이템 수
        for(int j=1; j<=k; j++){ //무게
        //i번째 아이템을 가방에 넣은 경우와 넣지 않은 경우 중 최대
        if(j >= items[i-1].first)
            dp[i][j] = max(dp[i-1][j-items[i-1].first]+items[i-1].second, dp[i-1][j]);
        else 
            dp[i][j] = dp[i-1][j];
        }
    }
    
    cout << dp[n][k]<<'\n';
    
    // for(int i=1; i<=n; i++){
    //     for(int j=1; j<=k; j++){
    //         cout << dp[i][j] <<'\n';
    //     }
    // }
    return 0;
}