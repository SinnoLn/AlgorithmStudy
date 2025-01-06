#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

unordered_map<char,int> map;
vector<int> solution(string s) {
    vector<int> answer;
    for(int i=0; i<s.size(); i++){
        if(map.find(s[i]) == map.end()){
            map[s[i]] = i;
            answer.push_back(-1);
        }
        else{
            int position = map[s[i]];
            answer.push_back(i-position);
            map[s[i]] = i;
        }
    }
    return answer;
}