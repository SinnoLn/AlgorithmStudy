#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<pair<int,int>> datas;
vector<int> solution(vector<int> emergency) {
    vector<int> answer(emergency.size());
    for(int i=0; i<emergency.size(); i++){
        datas.push_back({emergency[i],i});
    }
    
    sort(datas.rbegin(), datas.rend());
    for(int i=0; i<datas.size(); i++){
        answer[datas[i].second] = i+1;
    }
    
    return answer;
}