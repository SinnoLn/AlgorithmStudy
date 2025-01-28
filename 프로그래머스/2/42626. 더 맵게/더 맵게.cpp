#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

priority_queue<int> pq;
int solution(vector<int> scoville, int K) {
    int answer = 0;
    for(int i=0; i<scoville.size(); i++) pq.push(-scoville[i]);
    
    while(!pq.empty()){
        int food1 = pq.top();
        pq.pop();
        if(pq.size()>=1 && -food1 < K){
            int food2 = pq.top();
            pq.pop();
            pq.push(food1 + food2*2);
            answer++;
        }
        else if(-food1 >= K) return answer;
    }
    return -1;
}