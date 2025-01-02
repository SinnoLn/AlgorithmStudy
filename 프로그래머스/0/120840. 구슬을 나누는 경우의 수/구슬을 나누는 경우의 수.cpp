#include <string>
#include <vector>
#include <iostream>

using namespace std;

//조합 공식을 사용하자
//서로 다른 balls개의 구슬 중, share개를 뽑는다.
int solution(int balls, int share) {
    int answer = 0;
    long long tmp = 1;
    if(share > balls-share) share = balls-share;
    
    for (int i = 1; i <= share; i++) {
        tmp = tmp * (balls - i + 1) / i; 
    }
    answer = tmp;
    return answer;
}