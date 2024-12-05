#include <string>
#include <vector>

using namespace std;
int stock[31]; //1부터 시작

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    for(int i=0; i<reserve.size();i++){
        stock[reserve[i]]++;
    }
    for(int i=0; i<lost.size(); i++){
        stock[lost[i]]--;
    }
    
    for(int i=1; i<=n; i++){
        if(stock[i] == -1){ //체육복이 없다면
            if(stock[i-1] == 1) stock[i-1]--, stock[i]++;
            else if(stock[i+1] == 1) stock[i+1]--, stock[i]++;
        }
    }
    
    for(int i=1; i<=n; i++){
        if(stock[i] != -1) answer++;
    }
    return answer;
}