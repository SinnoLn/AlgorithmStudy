#include <string>
#include <vector>
#include <iostream>

using namespace std;
void check_danger_area(int x, int y, int n);

int danger_area, safe_area;
int visited[100][100];
//대각선까지 이동하기 위한 배열
int dx[9] = {0,-1,1,0,0,-1,-1,1,1};
int dy[9] = {0,0,0,-1,1,-1,1,-1,1};

int solution(vector<vector<int>> board) {
    for(int i=0; i<board.size(); i++){
        for(int j=0; j<board.size(); j++){
            if(board[i][j] == 1){
                check_danger_area(i,j,board.size());
            }
        }
    }
    safe_area = board.size()*board.size() - danger_area;
    return safe_area;
}

void check_danger_area(int x, int y, int n){
    for(int i=0; i<9; i++){
        int nx = dx[i] + x;
        int ny = dy[i] + y;
        if(nx < 0 || ny < 0 || nx > n-1 || ny > n-1)continue;
        //cout << "visited[nx][ny] : " <<visited[nx][ny] <<'\n';
        //cout << "nx : " <<nx <<  " ny : " <<ny <<'\n';
        if(visited[nx][ny] == 1) continue;

        visited[nx][ny] = 1;
        danger_area++;
    }
}