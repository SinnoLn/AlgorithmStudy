#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int tmp;
//1. sides중에서 가장 긴 경우, 2.새로운 변이 가장 긴 경우
int solution(vector<int> sides) {
    int answer = 0;
    if(sides[1] > sides[0]){
        tmp = sides[1];
        sides[1] = sides[0];
        sides[0] = tmp;
    }
    answer+=sides[1];
    cout << answer << '\n';
    answer+=(sides[1]+sides[0])-1-sides[0];
    cout << answer << '\n';
    return answer;
}