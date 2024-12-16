#include <string>
#include <vector>

using namespace std;

int solution(string n_str) {
    int answer = 0;
    for(int i=0; i<n_str.size(); i++){
        answer+=n_str[i]-'0';
        answer*=10;
    }
    answer/=10;
    return answer;
}