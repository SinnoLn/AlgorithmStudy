#include <string>
#include <vector>
#include <iostream>

using namespace std;

string s;
int solution(string my_string) {
    int answer = 0;
    for(char c : my_string){
        if(isdigit(c)) s+=c;
        if(isalpha(c)&&s.size() != 0){
            answer+=stoi(s);
            s="";
        }
    }
    if(s.size() != 0)answer+=stoi(s);
    return answer;
}