#include <string>
#include <vector>
#include <iostream>

using namespace std;
int dicA[26];
int dica[26];

vector<int> solution(string my_string) {
    vector<int> answer;
    for(char c : my_string) {
        if(c >='a' && c<='z') dica[c-'a']++;
        else if(c >='A' && c<='Z') dicA[c-'A']++;
    }
    
    for(int i: dicA) answer.push_back(i);
    for(int i: dica) answer.push_back(i);

    return answer;
}