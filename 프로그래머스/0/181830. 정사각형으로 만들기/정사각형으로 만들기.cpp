#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int max_arr,max_col;
vector<vector<int>> solution(vector<vector<int>> arr) {
    
    max_col = arr.size();
    for(int i=0; i<arr.size(); i++){
        int tmp = arr[i].size();
        max_arr = max(max_arr, tmp);
    }
    
    cout << max_arr <<'\n';
    cout << max_col <<'\n';
    
    if(max_arr > max_col){
        int diff = max_arr - max_col;
        for (int i = 0; i < diff; i++) {
            arr.push_back(vector<int>(max_arr, 0));
        }
    }
    else if(max_arr < max_col){
        for (int i = 0; i < arr.size(); i++) {
            arr[i].resize(max_col, 0);
        }
    }
    
    return arr;
}