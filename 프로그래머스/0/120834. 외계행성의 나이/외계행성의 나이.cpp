#include <string>
#include <vector>
#include <algorithm>

using namespace std;
string alp = "abcdefghijklmnopqrstuvwxyz";

string solution(int age) {
    string answer = "";
    for(char c : to_string(age)){
        answer+=alp[c-'0'];
    }
    return answer;
}