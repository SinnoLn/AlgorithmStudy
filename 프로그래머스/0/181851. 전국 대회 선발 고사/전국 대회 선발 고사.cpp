#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> rank, vector<bool> attendance) {
    int answer = 0;
    vector<pair<int,int>> tmp;
    for(int i=0; i<attendance.size(); i++){
        if(attendance[i]) tmp.push_back({rank[i],i});
    }
    sort(tmp.begin(), tmp.end());
    answer = tmp[0].second*10000+tmp[1].second*100+tmp[2].second;
    return answer;
}