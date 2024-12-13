#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    stringstream ss(my_string);
    string s1;
    while(ss >> s1){
        answer.push_back(s1);    
    }
    return answer;
}