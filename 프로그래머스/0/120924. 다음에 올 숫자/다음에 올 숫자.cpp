#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> common) {
    int answer = 0;
    int diff1 = common[1] - common[0];
    int diff2 = common[2] - common[1];
    
    //등차수열
    if(diff1 == diff2){
        answer= common[common.size()-1] + diff1;
    }
    //등비수열
    else {
        answer= common[common.size()-1] * (diff2/diff1);
    }
    
    return answer;
}