#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

queue<int>q;
bool check_higher;
int solution(vector<int> priorities, int location) {
    int answer = 0;
    for(int i=0; i<priorities.size(); i++) q.push(i);
    
    while(!q.empty()){
        int current_num = q.front();
        int propority = priorities[0];
        q.pop();
        
        check_higher = false;
        for(int i : priorities){
            if(propority<i) {
                check_higher = true;
                break;
            }
        }
        
        if(check_higher) {
            q.push(current_num);
            priorities.push_back(propority);
            priorities.erase(priorities.begin());
        }
        else {
            answer++;
            if(current_num == location) return answer;
            priorities.erase(priorities.begin());
        }
    }
    return answer;
}