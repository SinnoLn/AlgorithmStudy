#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> numbers, int k) {
    int answer = 0;
    int all_num = numbers.size();
    int position = 0;
    
    for(int i=0; i<k-1; i++){
        position = (position+2)%all_num;
        // cout << position << '\n';
    }
    answer = numbers[position];
    return answer;
}