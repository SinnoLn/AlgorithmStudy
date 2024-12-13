#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int pos;
vector<string> solution(string myString) {
    vector<string> answer;
    while(myString.find('x') != string::npos){
        pos = myString.find('x');
        if(pos != 0) answer.emplace_back(myString.substr(0,pos));
        myString.erase(0,pos+1);
    }
    if(!myString.empty()) answer.emplace_back(myString);
    sort(answer.begin(), answer.end());
    
    return answer;
}