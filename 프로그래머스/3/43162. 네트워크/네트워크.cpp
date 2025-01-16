#include <string>
#include <vector>

using namespace std;

bool visited[200];
int answer;
void dfs(int current, int n, vector<vector<int>>& computers);
int solution(int n, vector<vector<int>> computers) {
    for(int i=0; i<n; i++){
        if(!visited[i]){
            dfs(i,n,computers);
            answer++;
        }
    }
    return answer;
}

void dfs(int current, int n, vector<vector<int>>& computers){
    visited[current] = true;
    for(int i=0; i<n; i++){
        if(computers[current][i] == 1 && !visited[i]){
            dfs(i, n, computers);
        }
    }
}