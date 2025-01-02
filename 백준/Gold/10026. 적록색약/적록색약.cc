#include <iostream>

using namespace std;
int nx[4] = {1,0,-1,0};
int ny[4] = {0,1,0,-1};
int save[100][100];
bool visited[100][100];
void bfs(int x, int y);
int x, y, n, normal, blindness;
char c;
//R은 1, B는 2, G는 3
int main() {
    cin >> n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> c;
            if(c=='R') save[i][j] = 1;
            else if(c=='B') save[i][j] = 2;
            else if(c=='G') save[i][j] = 3;
        }
    }
    
    for(int i=0 ;i<n; i++){
        for(int j=0; j<n; j++){
            if(!visited[i][j]) {
                normal++;
                bfs(i,j);
            }
        }
    }
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            visited[i][j] = false;
            if(save[i][j] == 3) save[i][j] = 1;
        } 
    }
    
    for(int i=0 ;i<n; i++){
        for(int j=0; j<n; j++){
            if(!visited[i][j]) {
                blindness++;
                bfs(i,j);
            }
        }
    }
    cout << normal <<" "<<blindness<<'\n';
    return 0;
}
void bfs(int x, int y){
    visited[x][y] = true;
    for(int i=0; i<4; i++){
        int dx = x + nx[i];
        int dy = y + ny[i];
        
        if(dx<0 || dy<0 || dx>=n || dy>=n) continue;
        if(visited[dx][dy]) continue;
        if(save[x][y] != save[dx][dy]) continue;
        bfs(dx, dy);
    }
}