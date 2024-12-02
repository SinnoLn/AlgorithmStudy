#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> ans;
string s;
long long solution(long long n) {
    long long answer = 0;
    s = to_string(n);
    
    for(int i=0; i<s.size(); i++){
        ans.push_back(s[i]-'0');
    }
    
    sort(ans.rbegin(), ans.rend());
    
    for(int i=0; i<s.size(); i++){
        answer+=ans[i];
        answer*=10;
    }
    answer/=10;
    return answer;
}