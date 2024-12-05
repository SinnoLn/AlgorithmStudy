#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

string solution(string my_string, vector<vector<int>> queries) {
    for(int i=0; i<queries.size(); i++){
        int start = queries[i][0];
        int end = queries[i][1];
        
        reverse(my_string.begin()+start, my_string.begin()+end+1);
    }
    return my_string;
}