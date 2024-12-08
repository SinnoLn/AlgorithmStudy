#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> intervals) {
    vector<int> answer;
    for(int i=intervals[0][0]; i<=intervals[0][1]; i++) answer.push_back(arr[i]);
    for(int i=intervals[1][0]; i<=intervals[1][1]; i++) answer.push_back(arr[i]);
    return answer;
}