#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

const int max_n = 104;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int n, m, a[max_n][max_n], visited[max_n][max_n], y, x; 
char c;

int main() {

    cin >> n >> m;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++) {
        cin >> c;
        a[i][j] = c - '0';
      }
    }

    queue<pair<int,int>> q;
    visited[0][0] = 1; //0,0 (문제상 1,1) 부터 시작하므로 방문했다고 표시
    q.push(make_pair(0,0));

    while(!q.empty()){
      tie(y,x) = q.front(); //여러 변수 한번에 초기화 방법
      q.pop();
      for(int i=0; i<4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || a[ny][nx] == 0) continue;
        if(visited[ny][nx]) continue;
        visited[ny][nx] = visited[y][x] + 1;
        q.push(make_pair(ny, nx));
      }
    }

    // 최종적으로 (n-1, m-1) 위치에 있는 최소 칸 수 출력
    cout << visited[n-1][m-1] << '\n';

    return 0;
}
