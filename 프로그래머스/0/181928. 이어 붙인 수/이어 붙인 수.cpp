#include <string>
#include <vector>

using namespace std;
int odd, even;
int solution(vector<int> num_list) {
    int answer = 0;
    for(int i=0; i<num_list.size(); i++){
        if(num_list[i]%2 == 0){
            even+=num_list[i];
            even*=10;
        }
        else if(num_list[i]%2 == 1){
            odd+=num_list[i];
            odd*=10;
        }
    }
    answer=(odd+even)/10;
    return answer;
}