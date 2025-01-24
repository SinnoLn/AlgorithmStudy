#include <string>
#include <vector>

using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    for(char c : s){
        int i=0;
        while(i < index){
            c++;
            if(c>122) c-=26;
            if(skip.find(c) != string::npos) continue;
            i++;
        }
        answer+=c;
    }
    return answer;
}