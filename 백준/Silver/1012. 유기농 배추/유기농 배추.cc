#include <iostream>

using namespace std;

int test, w, l, num, cy, cx, ny, nx, ret;

const int V = 55;
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
int a[V][V];
bool visited[V][V];

void dfs(int y, int x){
    visited[y][x] = true;
    for(int i = 0; i < 4; i++) {
        ny = y + dy[i];
        nx = x + dx[i];
        if (ny < 0 || nx < 0 || ny >= l || nx >= w) continue; // 범위 체크
        if (a[ny][nx] == 1 && !visited[ny][nx]) {
            dfs(ny, nx);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> test;
    for(int i = 0; i < test; i++) {
        cin >> w >> l >> num;
        for(int j = 0; j < num; j++) {
            cin >> cx >> cy;  // 입력받은 좌표를 cy, cx로 처리
            a[cy][cx] = 1;
        }
        
        for(int y = 0; y < l; y++) {
            for(int x = 0; x < w; x++) {
                if (a[y][x] == 1 && !visited[y][x]) {
                    dfs(y, x);  // 새로운 배추 덩어리 발견 시 탐색
                    ret++;
                }
            }
        }

        cout << ret << '\n';


        // 다음 테스트 케이스를 위해 배열 초기화
        ret = 0;
        for(int y = 0; y < l; y++) {
            for(int x = 0; x < w; x++) {
                a[y][x] = 0;
                visited[y][x] = false;
            }
        }
    }

    return 0;
}