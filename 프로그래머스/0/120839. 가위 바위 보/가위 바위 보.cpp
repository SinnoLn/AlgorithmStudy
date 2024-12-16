#include <string>
#include <vector>

using namespace std;

//가위 2 바위 0 보 5
string solution(string rsp) {
    string answer = "";
    for(char c : rsp){
        if(c == '2') answer+='0';
        else if(c == '5') answer+='2';
        else answer+='5';
    }
    return answer;
}