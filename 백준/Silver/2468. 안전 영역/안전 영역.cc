#include <iostream>

using namespace std;

void dfs(int y, int x, int d);

const int V = 105;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0 ,1, 0, -1};
int a[V][V];
bool visited[V][V];
int h, n, ret, ny, nx, max_h = -1, max_ = -1, d;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> h;
    for(int i=0; i<h; i++){
      for(int j=0; j<h; j++){
        cin >> n;
        if(max_h < n) max_h = n;
        a[i][j] = n;
      }
    }
    
    for(d=0; d<=max_h; d++){ //비가 전혀 오지 않았을때도 고려
        for(int i=0; i<h; i++){
          for(int j=0; j<h; j++){
            if(a[i][j] > d && !visited[i][j]){
              dfs(i, j, d);
              ret ++;
            }
          }
        }
        max_ = max(max_, ret); 
        
        //초기화
        ret = 0;
        for(int i=0; i<h; i++){
            for(int j=0; j<h; j++)
                visited[i][j] = 0;
        }
    }
    cout << max_ << '\n';
  return 0;
}

void dfs(int y, int x, int d){
  visited[y][x] = 1;
  for(int i=0; i<4; i++) {
    ny = y + dy[i];
    nx = x + dx[i];
    if(ny<0 || nx<0 || ny >= h || nx >= h) continue;
    if(a[ny][nx] > d && !visited[ny][nx]) {
      dfs(ny, nx, d);
    }
  }
}