#include <string>
#include <vector>
#include <sstream>
#include <unordered_map>
#include <iostream>

using namespace std;

bool report_list[1000][1000];
string user, reported_user;
int user_index, reported_user_index;
unordered_map<string,pair<int,int>> map;
vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size());
    for(int i=0; i<id_list.size(); i++) map[id_list[i]]={i,0};
    for(string s : report){
        stringstream ss(s);
        ss >> user >> reported_user;
        user_index = map[user].first;
        reported_user_index = map[reported_user].first;
        
        if(!report_list[reported_user_index][user_index]){
            report_list[reported_user_index][user_index] = true;
            map[reported_user].second++;
        }
    }
    
    for(auto& iter : map){
        if(iter.second.second >= k){
            int tmp = 0;
            for(int i=0; i<id_list.size(); i++){
                if(report_list[iter.second.first][i]) answer[i]++;
            }
        }
    }
    return answer;
}