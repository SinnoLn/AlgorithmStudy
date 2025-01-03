#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<int> num_list, int n) {
    vector<vector<int>> answer;
    int point = 0;
    for(int i=0; i<num_list.size()/n; i++){
        vector<int> row; 
        for(int j=0; j<n; j++){
            row.push_back(num_list[point]);
            point++;
        }
        answer.push_back(row);
    }
    return answer;
}