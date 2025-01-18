#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

queue<pair<int,int>>q;
bool check_higher;
int solution(vector<int> priorities, int location) {
    int answer = 0;
    for(int i=0; i<priorities.size(); i++) q.push({i,priorities[i]});
    
    while(!q.empty()){
        pair<int,int> tmp = q.front();
        q.pop();
        
        check_higher = false;
        for(int i : priorities){
            if(tmp.second<i) {
                check_higher = true;
                break;
            }
        }
        
        if(check_higher) {
            q.push(tmp);
            priorities.erase(priorities.begin());
            priorities.push_back(tmp.second);
        }
        else {
            answer++;
            if(tmp.first == location) return answer;
            priorities.erase(priorities.begin());
        }
    }
    return answer;
}