#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    int count = 0;
    int add = x;
    while(count != n){
        answer.push_back(x);
        x+=add;
        count++;
    }
    return answer;
}