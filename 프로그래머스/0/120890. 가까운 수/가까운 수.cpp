#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(vector<int> array, int n) {
    int diff = 1000;
    int answer = 0;
    for(int i : array){
        if(diff > abs(n-i) ){
            diff = abs(n-i);
            answer = i;
        }
        else if((diff == abs(n-i))&& i<answer) answer = i;
    }
    return answer;
}