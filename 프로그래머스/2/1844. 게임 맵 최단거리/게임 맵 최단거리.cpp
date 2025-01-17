#include<vector>
#include<queue>
using namespace std;

int answer;
bool visited[100][100];
int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};

int solution(vector<vector<int>> maps){
    int w = maps[0].size();
    int h = maps.size();
    
    queue<pair<pair<int, int>, int>> q;
    q.push({{0,0},1});
    visited[0][0] = true;
    
    while(!q.empty()){
        int y = q.front().first.first;
        int x = q.front().first.second;
        int distance = q.front().second;
        
        q.pop();
        
        if(x == w-1 && y== h-1) return distance;
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx>=w || nx<0 || ny>=h || ny<0 ) continue;
            if(maps[ny][nx] == 0 || visited[ny][nx]) continue;
            
            q.push({{ny,nx},distance+1});
            visited[ny][nx] = true;
            answer++;
        }
    }
    return -1;
}