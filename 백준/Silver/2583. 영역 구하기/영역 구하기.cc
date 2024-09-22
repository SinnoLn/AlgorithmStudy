#include <iostream>
#include <vector>
#include <algorithm>
#define MAX_NUM 100

using namespace std;
int n, m, k, x, y, ny, nx, fx, fy, ex, ey,sum, rs;
int a[MAX_NUM][MAX_NUM] = {0,};
bool visited[MAX_NUM][MAX_NUM];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
vector<int> ret;
//0이 디폴트고 1이 사각형으로 채워지는 부분

void dfs(int y, int x);

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> m >> n >> k;
    for(int i=0; i<k; i++){
        cin >> fx >> fy >> ex >> ey;
        for(int x=fx; x<ex; x++)
            for(int y=fy; y<ey; y++)
                a[y][x] = 1; //주의!!!!!! 뒤집어서 해야함!!!!!
    }
    
    for(int y = 0; y < m; y++) {
        for(int x = 0; x < n; x++) {
            if (a[y][x] == 0 && !visited[y][x]) {
                sum = 0;
                dfs(y, x); 
                rs ++;
                ret.push_back(sum);
            }
        }
    }
    
    sort(ret.begin(), ret.end());
    
    cout << rs << '\n';
    for(int i=0; i<ret.size(); i++)
    {
        cout << ret[i]<<" ";
    }
    
    return 0;
}

void dfs(int y, int x){
    visited[y][x] = 1; //방문처리
    sum++;
    for(int i=0; i<4; i++) {
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny<0 || nx<0 || ny >= m || nx >= n) continue; //인접행렬 범위안에 있는지
        if (a[ny][nx] == 0 && !visited[ny][nx]) { //지나갈 수 있고 방문안했으면 dfs go
            dfs(ny, nx);
        }
    }
}