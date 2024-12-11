#include <string>
#include <vector>
#include <cctype>

using namespace std;

string solution(string myString) {
    string answer = "";
    for(char c : myString){
        if( c == 'a') answer+=c-32;
        else if(c != 'A') answer+= tolower(c);
        else answer+=c;
    }
    return answer;
}