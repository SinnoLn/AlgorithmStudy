#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <cmath>

using namespace std;

//투포인터로 해결하면 될듯
int position=-1, min_diff=2100000000;
vector<int> solution(vector<int> numlist, int n) {
    vector<int> answer;
    sort(numlist.begin(), numlist.end());
    for(int i=0; i<numlist.size(); i++){
         if(min_diff >= abs(n-numlist[i]) && position < i){
             position = i;
             min_diff = abs(n-numlist[i]);
         }
    }
    int right = position;
    int left = position-1;
    while(left !=-1 && right != numlist.size()){
        if(right != numlist.size() && abs(numlist[left]-n) >= abs(numlist[right]-n)) {
            answer.push_back(numlist[right]);
            right++;
        }
        else if(left !=-1 && abs(numlist[left]-n) < abs(numlist[right]-n)) { 
                answer.push_back(numlist[left]);
                left--;
        }
    }
    
    while(right != numlist.size()) {
        answer.push_back(numlist[right]);
        right++;
    }
    while(left !=-1) {
        answer.push_back(numlist[left]);
        left--;
    }
    return answer;
}