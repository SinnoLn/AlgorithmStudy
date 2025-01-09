#include <string>
#include <vector>

using namespace std;

bool check;
int solution(vector<string> spell, vector<string> dic) {
    int answer = 0;
    for(string s : dic){
        check = true;
        for(string c : spell){
            if(s.find(c) == string::npos){
                check = false;
                break;
            }
        }
        if(check) answer++;
    }
    if(answer == 0) answer = 2;
    else answer = 1;
    return answer;
}