#include <string>
#include <vector>
#include <sstream>

using namespace std;

string num1, num2, ans;
char op, eq;
vector<string> solution(vector<string> quiz) {
    vector<string> answer;
    for(string s : quiz){
            stringstream ss(s);
            ss >> num1 >> op >> num2 >> eq >> ans;
            if(op == '-'){
                if(stoi(num1)-stoi(num2) == stoi(ans)) answer.push_back("O");
                else answer.push_back("X");
            }
            else if(op == '+'){
                if(stoi(num1)+stoi(num2) == stoi(ans)) answer.push_back("O");
                else answer.push_back("X");
            }
        }
    return answer;
}