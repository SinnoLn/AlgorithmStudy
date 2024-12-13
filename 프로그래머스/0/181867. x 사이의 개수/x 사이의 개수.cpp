#include <string>
#include <vector>
#include <iostream>

using namespace std;

int pos;
vector<int> solution(string myString) {
    vector<int> answer;
    while(myString.find('x') != string::npos){
        pos = myString.find('x');
        // cout << pos <<'\n';
        myString.erase(0,pos+1);
        answer.emplace_back(pos);
    }
    answer.emplace_back(myString.size());
    
    return answer;
}