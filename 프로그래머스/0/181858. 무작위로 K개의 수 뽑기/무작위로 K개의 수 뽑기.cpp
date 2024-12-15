#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    vector<int> answer;
    for(int i=0; i<arr.size(); i++){
        if(find(answer.begin(),answer.end(),arr[i]) == answer.end()) answer.push_back(arr[i]);
        if(answer.size() == k) break;
    }
    int size = answer.size();
    if(answer.size() < k){
        for(int i=0; i<k-size; i++)
            //answer.size()가 push할때마다 동적으로 증가해서 안됨
            answer.push_back(-1);
    }
    return answer;
}