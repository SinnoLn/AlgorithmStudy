#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
int a, b;
vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for(int i=0; i<queries.size(); i++){
        //a = find(arr.begin(), arr.end(), queries[i][0]) - arr.begin();
        //cout << "a : " << a << '\n';
        //b = find(arr.begin(), arr.end(), queries[i][1]) - arr.begin();
        //cout << "b : " << b << '\n';
        swap(arr[queries[i][0]], arr[queries[i][1]]);
    }
    return arr;
}