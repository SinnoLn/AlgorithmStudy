#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

queue<int> q;
int tmp;
vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    for(int i=0; i<progresses.size();i++){
        int rest_day = (100-progresses[i])/speeds[i];
        if((100-progresses[i])%speeds[i] != 0) rest_day++;
        
        cout << rest_day << '\n';
        
        if(q.empty()){
            q.push(rest_day);
            tmp++;
        }
        else{
            if(rest_day <= q.front()){
                tmp++;
                cout <<"1. " << rest_day << " : " << q.front() << '\n';
            }
            else {
                cout <<"2. "<< rest_day << " : " << q.front() << '\n';
                answer.push_back(tmp);
                cout << tmp << '\n';
                tmp = 0;
                q.pop();
                q.push(rest_day);
                tmp++;
            }
        }
    }
    
    if(!q.empty()) answer.push_back(tmp);
    return answer;
}