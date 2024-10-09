#include <iostream>
#include <vector>
using namespace std;

//dfs로 풀자 (브루트포스)
int date, pay, times, maxAns = -1;
vector<pair<int,int>> task;

void dfs(int day, int currentPay);

int main(){

    //남은 일수와 상담시간과 비용 입력받음
    cin >> date;
    for(int i=0 ;i<date; i++){
        cin >> times >> pay;
        task.push_back({times, pay});
    }

    dfs(0,0);

    cout << maxAns << '\n';

    return 0;
}

void dfs(int day, int currentPay){

    //재귀 종료조건 설정
    if(day >= date){
        maxAns = max(maxAns, currentPay);
        return;
    }

    //상담을 할 경우
    if(day + task[day].first <= date)
        dfs(day+task[day].first ,currentPay + task[day].second);
    
    //상담할 수 없는 경우
    dfs(day + 1, currentPay);
}
