#include <string>
#include <vector>
#include <iostream>

using namespace std;
string solution(string s, int n) {
    string answer = "";
    
    for(char c : s){
        if(c == ' ')
            answer+=c;
        else {
            if(c >= 'a' && c <= 'z'){
                if(c+n > 122) answer+=(c+n)-26;
                else answer+= c+n;
                
            }
            else if(c >= 'A' && c <= 'Z'){
                if(c+n > 90) answer+=(c+n)-26;
                else answer+= c+n;
            }
        }
    }
    return answer;
}