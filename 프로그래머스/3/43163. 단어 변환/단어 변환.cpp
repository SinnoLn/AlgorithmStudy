#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

bool visited[50];
int solution(string begin, string target, vector<string> words) {

    if(find(words.begin(), words.end(), target) == words.end()) return 0;
    
    queue<pair<string, int>> q;
    q.push({begin, 0});
    while(!q.empty()){
        string current_name = q.front().first;
        int index = q.front().second;
        q.pop();
        
        if(current_name == target) return index;
        
        for(int i=0; i<words.size(); i++){
            int diff = 0;
            for(int j=0; j<words[i].size(); j++){
                if(words[i][j] != current_name[j]) diff++;
            }
            if(diff == 1 && !visited[i]){
                q.push({words[i],index+1});
                visited[i] = true;
            } 
        }
    }
    return 0;
}
