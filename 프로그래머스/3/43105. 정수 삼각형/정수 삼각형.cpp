#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int dp[500][500]; //500층의 500번까지의 최대 값
int solution(vector<vector<int>> triangle) {
    int answer = 0;

    for(int i=0; i<triangle.size(); i++) {
        dp[triangle.size()-1][i] = triangle[triangle.size()-1][i];
    }
    
    for(int i=triangle.size()-2; i>=0; i--){
       for(int j=0; j<triangle[i].size(); j++){
           dp[i][j] = triangle[i][j] + max(dp[i+1][j], dp[i+1][j+1]);
       } 
    }
    
    answer = dp[0][0];
    return answer;
}