#include <vector>
#include <iostream>
#include <map>
using namespace std;

map<int,int> ponketmon;
int solution(vector<int> nums){
    int answer = 0;
    //오름차순으로 정렬
    for(int i : nums)ponketmon[i]++;
    int max_num = nums.size()/2;
    
    if(ponketmon.size() >= max_num) answer = max_num;
    else answer = ponketmon.size();
    
    return answer;
}