#include <string>
#include <vector>
#include <cctype>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    for(int i=0; i<strArr.size(); i++){
        string s = "";
        for(char c : strArr[i]){
            if(i%2==0) s+=tolower(c);
            else s+=toupper(c);
        }
        answer.push_back(s);
    }
    return answer;
}