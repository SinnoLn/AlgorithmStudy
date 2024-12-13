#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <iostream>

using namespace std;


string s1;
char op;
vector<int> num;
int solution(string binomial) {
    stringstream ss(binomial);
    int answer = 0;
    
    while(ss >> s1){
        if(s1 == "+" || s1 == "-" || s1 == "*"){
            op = s1[0];
        }
        else num.emplace_back(stoi(s1));
    }
    // cout << num[0] << " : " << num[1] << '\n';
    // cout << op <<'\n';
    
    if(op == '+') answer = num[0]+num[1];
    else if(op == '-') answer = num[0]-num[1];
    else if(op == '*') answer = num[0]*num[1];
    
    return answer;
}