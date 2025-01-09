#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

//연속해서 같은 발음 불가
vector<string> can_pronounce = {"aya", "ye", "woo", "ma"};
int solution(vector<string> babbling) {
    int answer = 0;
    for(string s : babbling){
        for(string word : can_pronounce){
            int pos = 0;
            while((pos = s.find(word)) != string::npos){
                string tmp = word+word;
                if(s.find(tmp) != string::npos) break;
                s.replace(pos, word.length(),"0");
            }
        }
        bool check = true;
        for(char c: s){
            if(c != '0') check = false;
        }
        if(check)answer++;
    }
    return answer;
}