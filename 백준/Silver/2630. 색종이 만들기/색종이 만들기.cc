#include <iostream>
using namespace std;

int n;
int paper[130][130];
int white = 0, blue = 0;

void divide(int y, int x, int size) {
    int color = paper[y][x];
    bool sameColor = true;
    
    // 현재 영역이 모두 같은 색인지 확인
    for(int i = y; i < y + size; i++) {
        for(int j = x; j < x + size; j++) {
            if(paper[i][j] != color) {
                sameColor = false;
                break;
            }
        }
        if(!sameColor) break;
    }

    // 만약 모두 같은 색이면 해당 색 카운트 증가
    if(sameColor) {
        if(color == 0) white++;
        else blue++;
    } else {
        // 4개의 사분면으로 나눠서 다시 검사
        int newSize = size / 2;
        divide(y, x, newSize);              
        divide(y, x + newSize, newSize);    
        divide(y + newSize, x, newSize);      
        divide(y + newSize, x + newSize, newSize);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> paper[i][j];
        }
    }
    
    divide(0, 0, n);
    
    cout << white << '\n';
    cout << blue << '\n';

    return 0;
}