#include <string>
#include <vector>

using namespace std;

int alphabet[26];
int tmp[26];
int solution(string before, string after) {
    int answer = 1;
    for(int i=0; i<before.size(); i++) alphabet[before[i]-'a']++;
    for(int i=0; i<after.size(); i++) tmp[after[i]-'a']++;
    for(int i=0; i<26; i++){
        if(tmp[i] != alphabet[i]){
            answer = 0;
            break;
        }
    }
    return answer;
}