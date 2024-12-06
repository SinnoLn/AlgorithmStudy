#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> dic;
int answer;

int solution(string my_string, string is_suffix) {
    for(int i=1; i<=my_string.size(); i++){
        dic.push_back(my_string.substr(my_string.size()-i,i));
    }
    if(find(dic.begin(),dic.end(),is_suffix) != dic.end()) answer =1;
  
    return answer;
}