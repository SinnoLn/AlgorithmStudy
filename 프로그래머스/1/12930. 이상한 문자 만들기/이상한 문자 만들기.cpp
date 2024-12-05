#include <string>
#include <iostream>

using namespace std;
int count = 0;

string solution(string s) {
    string answer = "";
    for(char c : s){
        if(c == ' '){
            count = 0; //초기화하고 다시 시작
            answer += c; //공백이면 그냥 더해줌
        } 
        else {
            if((count%2 == 0) && (c>='a' && c<='z')) answer+=(c-32);
            else if((count%2 == 1) && (c>='A' && c<='Z')) answer+=(c+32);
            else answer+=c;
            //cout << "count : " << count <<'\n';
            count ++;
        }
    }
    return answer;
}