#include <string>
#include <vector>

using namespace std;

int solution(int order) {
    int answer = 0;
    string s_order = to_string(order);
    for(char c : s_order){
        if((c-'0') == 0) continue;
        if((c-'0')%3 == 0) answer++;
    }
    return answer;
}