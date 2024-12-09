#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int answer = 0;
    if(num_list.size() >= 11) {
        for(int i : num_list) answer+=i;
    }
    else if(num_list.size()<=10) {
        answer = 1;
        for(int i : num_list) answer*=i;
    }
    return answer;
}