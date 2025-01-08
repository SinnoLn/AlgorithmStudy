#include <string>
#include <vector>

using namespace std;

string s;
int solution(vector<int> array) {
    int answer = 0;
    for(int i : array){
        s = to_string(i);
        for(char c : s){
            if(c == '7') answer++;
        }
    }
    return answer;
}