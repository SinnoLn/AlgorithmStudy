#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    for(int i=l; i<=r; i++){
        bool chk = true;
        string s = to_string(i);
        for(char c:s){
            if(c != '5' && c != '0') chk = false; 
        }
        if (chk) answer.push_back(i);
    }
    if(answer.empty()) answer.push_back(-1);
    return answer;
}