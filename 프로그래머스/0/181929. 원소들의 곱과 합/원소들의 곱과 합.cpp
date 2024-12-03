#include <string>
#include <vector>

using namespace std;
int mult=1, sum;
int solution(vector<int> num_list) {
    int answer = 0;
    for(int i=0; i<num_list.size(); i++){
        mult*=num_list[i];
        sum+=num_list[i];
    }
    sum = sum*sum;
    if(mult < sum) answer = 1;
    else answer = 0;
    return answer;
}