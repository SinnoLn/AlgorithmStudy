#include <string>
#include <vector>
#include <iostream>

using namespace std;

int spiral_arr[30][30];

//오른쪽, 아래, 왼쪽, 위 
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int x, y, button, num=1;
vector<vector<int>> solution(int n) {
    vector<vector<int>> answer(n);
    spiral_arr[0][0] = num++;
        
    while(1){
        if(num > n*n) break;
        int nx = x + dx[button%4];
        int ny = y + dy[button%4];
        
        if(ny>=n || nx>=n || ny < 0 || nx < 0 || spiral_arr[ny][nx] != 0) {
            button++;
            continue;
        }
        spiral_arr[ny][nx] = num++;
        x = nx;
        y = ny;
    }
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            answer[i].push_back(spiral_arr[i][j]);
        }
    }
    
    return answer;
}