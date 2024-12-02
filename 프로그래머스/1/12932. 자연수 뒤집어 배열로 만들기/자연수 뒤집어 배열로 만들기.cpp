#include <string>
#include <vector>

using namespace std;

string s;
vector<int> solution(long long n) {
    vector<int> answer;
    s = to_string(n);
    for(int i=s.size()-1; i>=0; i--){
        answer.push_back(s[i]-'0');
    }
    return answer;
}