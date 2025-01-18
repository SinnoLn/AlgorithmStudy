#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<string> s_num;
bool cmp(string a, string b);
string solution(vector<int> numbers) {
    string answer = "";
    for(int i : numbers) s_num.push_back(to_string(i));
    sort(s_num.begin(), s_num.end(), cmp);
    for(string s : s_num) answer+=s;
    
    bool chk = true;
    for(char c : answer){
        if(c != '0') {
            chk = false;
            break;
        }
    }
    
    if(chk) answer="0";
    
    return answer;
}
bool cmp(string a, string b){
    return a+b > b+a;
}