#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> strArr) {
    vector<string> answer;
    for(int i=0; i<strArr.size(); i++){
        if(strArr[i].find("ad") == string::npos) //찾았는데 없으면 넣기
            answer.push_back(strArr[i]);
    }
    return answer;
}