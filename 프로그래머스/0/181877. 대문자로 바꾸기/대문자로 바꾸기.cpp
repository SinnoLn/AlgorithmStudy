#include <string>
#include <vector>
#include <cctype>

using namespace std;

string solution(string myString) {
    string answer ="";
    for(int i=0; i<myString.size(); i++) answer += toupper(myString[i]);
    return answer;
}