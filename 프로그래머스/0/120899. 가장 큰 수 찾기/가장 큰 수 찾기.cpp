#include <string>
#include <vector>

using namespace std;

int max_num = -1;
int position = -1;
vector<int> solution(vector<int> array) {
    vector<int> answer;
    for(int i=0; i<array.size(); i++){
        if(max_num < array[i]){
            max_num = array[i];
            position = i;
        }
    }
    answer.push_back(max_num);
    answer.push_back(position);
    return answer;
}