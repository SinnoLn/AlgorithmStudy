#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int stage=1, order;
unordered_map<string,string> map;
vector<int> solution(int n, vector<string> words) {
    map[words[0]] = words[0]; 
    for(int i=1; i<words.size(); i++){
        order = (i%n)+1;
        if(i%n == 0) stage++;
        if(map.find(words[i]) != map.end() ||words[i].front() != words[i-1].back()){
            return {order, stage};
        }
        map[words[i]] = 1;
    }
    return {0,0};
}