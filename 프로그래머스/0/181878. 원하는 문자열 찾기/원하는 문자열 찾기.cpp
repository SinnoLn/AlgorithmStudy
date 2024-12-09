#include <string>
#include <vector>
#include <cctype>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0;
    string u_myString ="";
    string u_pat ="";
    
    for(char c: myString) u_myString+=tolower(c);
    for(char c: pat) u_pat+=tolower(c);
    
    if(u_myString.find(u_pat) == string::npos) answer = 0;
    else answer = 1;

    return answer;
}