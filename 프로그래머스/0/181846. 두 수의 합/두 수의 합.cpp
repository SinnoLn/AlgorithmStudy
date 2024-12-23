#include <string>
#include <algorithm>

using namespace std;

string solution(string a, string b) {
    string answer = "";
    int carry = 0; 

    // a와 b의 길이가 다르면 짧은 문자열의 앞쪽에 0을 추가
    if (a.size() < b.size()) swap(a, b);
    b = string(a.size() - b.size(), '0') + b;

    for (int i = a.size() - 1; i >= 0; i--) {
        int sum = (a[i] - '0') + (b[i] - '0') + carry; 
        carry = sum / 10; 
        answer += (sum % 10) + '0'; 
    }

    // 마지막에 남은 자리 올림 처리
    if (carry > 0) {
        answer += carry + '0';
    }

    reverse(answer.begin(), answer.end());
    return answer;
}