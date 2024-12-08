#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int start = -1, finish= -1;
vector<int> solution(vector<int> arr) {
    vector<int> answer;
    for(int i=0; i<arr.size(); i++){
        if(arr[i] == 2){
            start = i;
            break;
        }
    }
    for(int i=arr.size(); i>=0; i--){
        if(arr[i] == 2){
            finish = i;
            break;
        }
    }    
    if(start == -1) answer.push_back(-1);
    else{
        for(int i=start; i<=finish; i++) answer.push_back(arr[i]);
    }
    
    return answer;
}