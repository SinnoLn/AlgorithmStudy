#include <string>
#include <vector>

using namespace std;

int sign = 1;
int solution(string s) {
    int answer = 0;
    for(char c : s){
        if(c == '-') sign = -1;
        else if(c == '+') sign = 1;
        else{
            answer+=c-'0';
            answer*=10;
        }
    }
    answer/=10;
    answer*=sign;
    return answer;
}