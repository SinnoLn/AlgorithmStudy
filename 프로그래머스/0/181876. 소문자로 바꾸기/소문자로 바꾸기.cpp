#include <string>
#include <vector>

using namespace std;

string solution(string myString) {
    string answer = "";
    for(char c: myString) { 
            if('a' <= c && c <= 'z') answer+=c;
            else answer+= c+32;
        }
    return answer;
}