#include <string>
#include <vector>

using namespace std;

int solution(vector<int> arr, int idx) {
    int answer = -4;
    for(int i=idx; i<arr.size(); i++){
        if(arr[i] == 1) {
            answer = i;
            break;
        } 
    }
    if(answer == -4) answer = -1;
    return answer;
}