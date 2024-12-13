#include <string>
#include <vector>
#include <iostream>

using namespace std;

int pos;
string solution(string myString, string pat) {
    string answer = "";
    while(myString.find(pat) != string::npos){
        pos = myString.find(pat);
        answer+=myString.substr(0,pos+pat.length());
        myString.erase(0, pos+pat.length());
    }
    
    cout << pos << '\n';
    return answer;
}