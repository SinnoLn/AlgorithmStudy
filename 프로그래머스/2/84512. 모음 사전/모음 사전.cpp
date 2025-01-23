#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int weight[5];
vector<int> vowel = {'A','E','I','O','U'};
int solution(string word) {
    int answer = 0;
    weight[0] = 1+5+(5*5)+(5*5*5)+(5*5*5*5);
    weight[1] = 1+5+(5*5)+(5*5*5);
    weight[2] = 1+5+(5*5);
    weight[3] = 1+5;
    weight[4] = 1;
    
    for(int i=0; i<word.size(); i++){
        int pos = find(vowel.begin(), vowel.end(), word[i]) - vowel.begin();
        answer+=(weight[i]*pos)+1;
    }
    return answer;
}