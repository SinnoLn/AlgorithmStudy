#include <string>
#include <vector>

using namespace std;

int dic[26];
string solution(string s) {
    string answer = "";
    for(char c : s){
        dic[c-'a']++;
    }
    for(int i=0; i<26; i++){
        if(dic[i] == 1) answer+=i+'a';
    }
    return answer;
}