#include <string>
#include <vector>

using namespace std;

int solution(string str1, string str2) {
    int answer = 0;
    if(str1.find(str2) != string::npos) answer = 1;
    else answer = 2;
    return answer;
}