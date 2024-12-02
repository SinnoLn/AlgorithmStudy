#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer;
    int po = 2100000000; 
   
    if(arr.size() == 1)
        answer.push_back(-1);
    else {
            for(int i=0; i<arr.size()-1; i++){
                if(po>min(arr[i], arr[i+1])){
                    po = min(arr[i], arr[i+1]);
                };
            } 
            for(int i=0; i<arr.size(); i++){
                if(arr[i] != po)
                    answer.push_back(arr[i]);
            }
        }
    return answer;
}