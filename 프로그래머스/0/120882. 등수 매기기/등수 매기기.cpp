#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<pair<float,int>> p;
int _rank = 1;
vector<int> solution(vector<vector<int>> score) {
    vector<int> answer(score.size());
    for(int i=0; i<score.size(); i++){
        float avg = (float)(score[i][0]+score[i][1])/2;
        p.push_back({avg,i});
    }
    sort(p.rbegin(), p.rend());
    
    answer[p[0].second] = _rank;
    for(int i=1; i<score.size(); i++){
        if(p[i-1].first == p[i].first){
            answer[p[i].second] = _rank;
        }
        else{
            _rank = i+1;
            answer[p[i].second] = _rank;
        }
    }
    return answer;
}