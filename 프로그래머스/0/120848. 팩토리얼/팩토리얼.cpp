#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    int tmp = 1;
    int i = 1;
    while(tmp <= n){
        tmp*=i;
        i++;
        answer++;
    }
    answer--; //마지막에 곱해진 값 빼줌
    return answer;
}