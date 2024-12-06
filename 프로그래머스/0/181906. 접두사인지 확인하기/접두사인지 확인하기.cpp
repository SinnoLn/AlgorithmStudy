#include <string>
#include <vector>
#include <algorithm>

using namespace std;
vector<string> dic;
int solution(string my_string, string is_prefix) {
    int answer = 0;
    for(int i=1; i<=my_string.size(); i++){
        dic.push_back(my_string.substr(0,i));
    }
    if(find(dic.begin(),dic.end(),is_prefix) != dic.end()) answer = 1;
    return answer;
}