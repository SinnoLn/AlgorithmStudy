#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int num, int k) {
    int answer = -1;
    string s = to_string(num);
    char c = k + '0';
    for(int i=1; i<=s.size(); i++){
        if(s[i-1] == c){
            answer = i;
            break;
        }
    }
    return answer;
}