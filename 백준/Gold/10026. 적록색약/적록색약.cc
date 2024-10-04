#include <iostream>
#define MAX 100
using namespace std;

int n; //배열 크기
char c; //RGB 입력받음
int color[MAX][MAX]; //색깔 숫자로 변경
bool visited[MAX][MAX]; //방문했는지 체크
int r,g,b,s; //각 색깔 세기
int y, x;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

void dfs(int c, int y, int x){
    visited[y][x] = 1; //방문처리
    for(int i=0; i<4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny<0 || nx<0 || ny>=n || nx>=n) continue; //범위안에 있는지 파악
        if(color[ny][nx]== c && !visited[ny][nx]) { //지나갈 수 있고 방문 안했다면 dfs go
            dfs(c, ny, nx);
        }
    }
}

//적록색맹일 경우 1과 2가 같이 취급됨
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            cin >> c; 
            if(c == 'R') color[i][j] = 1; //빨간색은 1
            else if(c == 'G') color[i][j] = 2; //초록색은 2
            else if(c == 'B') color[i][j] = 0; //파란색은 0
        }
    }
        
    //일반용    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(color[i][j] == 1 && !visited[i][j]){ //빨간색이고 지나갈 수 있으면
                dfs(1,i,j);
                r++;
            }
            else if(color[i][j] == 2 && !visited[i][j]){ //초록색이고 지나갈 수 있으면
                dfs(2,i,j);
                g++;
            }
            else if(color[i][j] == 0 && !visited[i][j]){ //파란색이고 지나갈 수 있으면
                dfs(0,i,j);
                b++;
            }
        }
    }
    
    //visited 배열 초기화, 2를 1로 바꿈
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            visited[i][j] = false;
            if(color[i][j] == 2)
                color[i][j] = 1; //change
        }
    }
    
    //적록색맹용
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if((color[i][j] == 1) && !visited[i][j]){ //빨강이나 초록이고 지나갈 수 있으면
                dfs(1,i,j);
                s++;
            }
        }
    }
    
    cout << r+g+b << " " << s+b << '\n';
        
    return 0;
}