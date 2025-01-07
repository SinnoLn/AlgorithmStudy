#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int num, int k) {
    int answer = -1;
    string s = to_string(num);
    string ks = to_string(k);
    for(int i=1; i<=s.size(); i++){
        if(s[i-1] == ks[0]){
            answer = i;
            break;
        }
    }
    return answer;
}