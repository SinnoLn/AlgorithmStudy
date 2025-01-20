#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

unordered_map<string,int>ranks;
vector<string> solution(vector<string> players, vector<string> callings) {
    
    for(int i=0; i<players.size(); i++) ranks[players[i]] = i;
    
    for(string s : callings){
        int current_rank = ranks[s];
        string prev_player = players[current_rank-1];
        
        swap(players[current_rank],players[current_rank-1]);
        ranks[s] --;
        ranks[prev_player]++; 
    }
    
    return players;
}