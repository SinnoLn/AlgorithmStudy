#include <iostream>
#include <queue>

using namespace std;

//100개의 노드
//1~6이 간선역할
int board[101];
bool visited[101];
queue<pair<int,int>> q;
int n,m;
int main() {
    cin >> n >> m;
    for(int i=1; i<101; i++) board[i] = i;
    for(int i=0; i<n+m; i++){
        int x, y;
        cin >> x >> y;
        board[x] = y;
    }
    
    q.push({1,0});
    visited[0] = true;
    
    while(!q.empty()){
        int current = q.front().first; //현재칸 처음은 1
        int rolls = q.front().second; //현재까지 굴린 주사위횟수 (처음은 0)
        q.pop();
        
        if(current == 100) { //100번째 위치에 왔으면
            cout << rolls << '\n'; //지금까지 굴린 주사위 수 출력
            return 0;
        }
        
        //주사위 굴리기
        for(int dice = 1; dice<=6; dice++){
            int next = current+dice;
            
            if(next > 100) continue;
            next = board[next];
            
            if(!visited[next]){
                visited[next] = true;
                q.push({next, rolls+1});
            }
        }
    }
    return 0;
}