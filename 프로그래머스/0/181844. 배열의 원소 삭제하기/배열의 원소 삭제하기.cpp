#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> delete_list) {
    vector<int> answer;
    for(int i=0; i<delete_list.size(); i++){
        replace(arr.begin(),arr.end(),delete_list[i],0); 
    }
    for(int i : arr) {
        if(i != 0) answer.push_back(i);
    }
    return answer;
}