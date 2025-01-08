#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    vector<int> answer;
    for(int i : arr){
        if(i%divisor == 0) answer.push_back(i);
    }
    sort(answer.begin(), answer.end());
    if(answer.size() == 0)answer.push_back(-1);
    return answer;
}