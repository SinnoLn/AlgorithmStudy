#include <string>
#include <vector>

using namespace std;

int first_num, other_num;
int solution(string s) {
    int answer = 0;
    while(!s.empty()){
        char first_word = s[0];
        for(int i=0; i<s.size(); i++){
            if(s[i] == first_word) first_num++;
            else other_num++;
            
            if(first_num == other_num) {
                s.erase(0,i+1);
                answer++;
                first_num = 0;
                other_num = 0;
                break;
            }
            if(i == s.size()-1) {
                s.erase(0,i+1);
                answer++;
            }
        }
    }
    return answer;
}