#include <string>
#include <vector>
#include <sstream>
#include <iostream>

using namespace std;

string s;
int i_sum, x_sum;
string solution(string polynomial) {
    string answer = "";
    stringstream ss(polynomial);
    while(ss >> s){
        if(s == "+") continue;
        if(s.find("x") != string::npos){
            if(s.size() == 1) x_sum+=1;
            else {
                s.erase(s.size()-1, 1);
                x_sum+=stoi(s);
            }
        }
        else i_sum += stoi(s);
    }
    
    if(x_sum == 0 && i_sum != 0) answer+=to_string(i_sum); 
    else if(x_sum != 0 && i_sum == 0){
        if(x_sum == 1) answer+="x";
        else {
            answer+=to_string(x_sum);
            answer+="x";
        }
    }
    else if(x_sum != 0 && i_sum != 0){
        if(x_sum == 1) answer+="x";
        else {
            answer+=to_string(x_sum);
            answer+="x";
        }
        answer+=" + ";
        answer+=to_string(i_sum);
    }

    return answer;
}