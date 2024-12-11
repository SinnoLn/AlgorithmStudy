#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string alp) {
    string answer = "";
    for(char c : my_string){
        if(c == alp[0]) answer+=c-32;
        else answer+=c;
    }
    return answer;
}