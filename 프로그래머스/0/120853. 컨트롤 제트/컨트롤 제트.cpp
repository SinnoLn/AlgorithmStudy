#include <string>
#include <vector>
#include <sstream>

using namespace std;

int memo;
int solution(string s) {
    int answer = 0;
    stringstream ss(s);
    while(ss >> s){
        
        if(s == "Z"){
            answer-=memo;
            continue;
        }
        else{
            memo = stoi(s);
        }
        answer+=stoi(s);

    }
    return answer;
}