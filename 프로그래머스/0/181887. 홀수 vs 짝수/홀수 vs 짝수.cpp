#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int sum_odd, sum_even;
int solution(vector<int> num_list) {
    int answer = 0;
    for(int i=0; i<num_list.size(); i++){
        if(i%2==0) sum_odd+=num_list[i];
        else sum_even+=num_list[i];
    }
    
    answer = max(sum_even, sum_odd);
    return answer;
}