#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
int len[201];
int solution(vector<vector<int>> lines) {
    int answer = 0;
    for(const auto& line : lines){
        int s = line[0]+100;
        int e = line[1]+100; 
        for(int i=s; i<e; i++){
            len[i]++;
        }
    }
    
    for(int i=0; i<201; i++){
        if(len[i] >=2) answer++;
    }
    
    return answer;
}