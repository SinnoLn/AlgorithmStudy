#include <string>
#include <vector>

using namespace std;

int position;
vector<string> pronounce = {"aya", "ye", "woo", "ma"};
int solution(vector<string> babbling) {
    int answer = 0;
    for(string s : babbling){
        for(string ss : pronounce){
            if((position = s.find(ss)) != string::npos){
                s.replace(position, ss.size(), "0");
            }
        }
        bool check = true;
        for(char c : s){
            if(c != '0'){
                check = false;
                break;
            }
        }
        if(check) answer++;
    }
    return answer;
}