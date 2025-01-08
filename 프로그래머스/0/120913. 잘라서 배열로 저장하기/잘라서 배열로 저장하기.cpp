#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> solution(string my_str, int n) {
    vector<string> answer;
    while(my_str.size() != 0){
        
        if(my_str.size()>=n){
            answer.push_back(my_str.substr(0,n));
            my_str.erase(0,n);
        }
        else{
            answer.push_back(my_str.substr(0,my_str.size()));
            my_str.erase(0,my_str.size());
        }
    }
    return answer;
}