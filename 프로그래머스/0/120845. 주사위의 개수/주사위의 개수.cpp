#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> box, int n) {
    int answer = 0;
    
    answer = (box[0]/n)*(box[1]/n)*(box[2]/n);
    return answer;
}