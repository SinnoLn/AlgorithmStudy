#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

int stage=1, order;
bool _check = true;
unordered_map<string,string> map;
vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    
    map[words[0]] = words[0]; 
    for(int i=1; i<words.size(); i++){
        order = (i%n)+1;
        if(i%n == 0) stage++;
        cout << "stage : " << stage << " order: " << order << '\n';
        if(map.find(words[i]) != map.end()){
            // cout << map[words[i]] << '\n';
            _check = false;
            break;
        }
        if(words[i].front() != words[i-1].back()){
            // cout << words[i].front() << " : " << words[i-1].back() << '\n';
            _check = false;
            break;
        }
        map[words[i]] = 1;
    }
    
    if(_check){
        order = 0;
        stage = 0;
    }
    answer.push_back(order);
    answer.push_back(stage);
    return answer;
}