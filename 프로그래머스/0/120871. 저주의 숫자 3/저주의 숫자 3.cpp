#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0, num = 0;
    while(num != n){
        answer++;
        if(answer%3==0 || to_string(answer).find('3') != string::npos){
            while(answer%3==0 || to_string(answer).find('3') != string::npos){
            answer++;
            }
        }
        num++;
    }
    return answer;
}