#include <string>
#include <vector>
#include <sstream>
#include <queue>

using namespace std;

queue<int> num;
queue<int> op;

int solution(string my_string) {
    int answer = 0;
    string s = "";
    stringstream ss(my_string);
    
    while(ss >> s){
        if(s == "+"){
            op.push(1);
            continue;
        }
        else if(s == "-"){
            op.push(-1);
            continue;
        }
        num.push(stoi(s));
    }
    
    answer = num.front();
    num.pop();
    while(!num.empty()){
        answer += num.front()*op.front();
        num.pop();
        op.pop();
    }
    return answer;
}