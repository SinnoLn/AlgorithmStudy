#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<string> s1, vector<string> s2) {
    int answer = 0;
    if(s1.size() > s2.size()){
        for(string s : s1){
            if(find(s2.begin(), s2.end(), s) != s2.end()) answer++;
        }
    }
    else{
        for(string s : s2){
            if(find(s1.begin(), s1.end(), s) != s1.end()) answer++;
        }
    }
    return answer;
}