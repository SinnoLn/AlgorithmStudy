#include <string>
#include <vector>
#include <algorithm>
#include <cstdlib>

using namespace std;
vector<pair<int,int>> dice;
int solution(int a, int b, int c, int d) {
    int answer = 0;
    for(int i=0; i<=6; i++){
        dice.push_back({0,i});
    }
    dice[a].first++;
    dice[b].first++;
    dice[c].first++;
    dice[d].first++;
    sort(dice.rbegin(), dice.rend());
    
    //4개의 수가 전부 같으면
    if(dice[0].first == 4) answer = 1111*dice[0].second;
    //3개의 수가 같으면
    else if(dice[0].first==3) answer = (10*dice[0].second+dice[1].second)*(10*dice[0].second+dice[1].second);
    //2개 2개씩 수가 같으면
    else if(dice[0].first==2 && dice[1].first==2) answer = (dice[0].second+dice[1].second) * abs(dice[0].second-dice[1].second);
    else if (dice[0].first==2 && dice[1].first==1) answer = dice[1].second * dice[2].second;
    else answer = dice[3].second;
    
    return answer;
}