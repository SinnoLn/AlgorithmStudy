#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int max_width, max_height;
int solution(vector<vector<int>> sizes) {
    int answer = 0;
    for(int i=0; i<sizes.size(); i++){
        if(sizes[i][0] < sizes[i][1]) swap(sizes[i][0],sizes[i][1]);
        if(max_width < sizes[i][0]) max_width = sizes[i][0];
        if(max_height < sizes[i][1]) max_height = sizes[i][1];
    }
    return max_width*max_height;
}