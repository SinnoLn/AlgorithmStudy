#include <string>
#include <vector>

using namespace std;
int odd, even;
vector<int> solution(vector<int> num_list) {
    vector<int> answer;
    for(int i=0; i<num_list.size();i++){
        if(num_list[i]%2==0) even++;
        else odd++;
    }
    answer.push_back(even);
    answer.push_back(odd);
    return answer;
}