#include <string>
#include <vector>

using namespace std;
vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> answer;
    for(int i=0; i<queries.size(); i++){
        int m = 100000000;
        for(int j=queries[i][0]; j<=queries[i][1]; j++){
            if(arr[j] > queries[i][2] && m > arr[j]){
                m = arr[j];
            }
        }
        if(m == 100000000) m = -1;
        answer.push_back(m);
    }
    return answer;
}