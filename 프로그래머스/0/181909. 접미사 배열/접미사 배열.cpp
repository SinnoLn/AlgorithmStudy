#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(string my_string) {
    vector<string> answer;
    for(int i=1; i<=my_string.size(); i++){
        answer.push_back(my_string.substr(my_string.size()-i,i));
    }
    sort(answer.begin(), answer.end());
    return answer;
}