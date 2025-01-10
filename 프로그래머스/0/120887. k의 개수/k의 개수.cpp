#include <string>
#include <vector>

using namespace std;

int solution(int i, int j, int k) {
    int answer = 0;
    char ck = k+'0';
    for(int num=i; num<=j; num++){
        string s = to_string(num);
        for(char c: s){
            if(c == ck) answer++;
        }
    }
    return answer;
}