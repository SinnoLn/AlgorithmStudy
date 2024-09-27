#include <iostream>

using namespace std;

int cw[5][8];  
int test, num, mg, position[5], isRotate[5], score;
bool point[4];  
char c;

void rotate_cw(int& pos) {
    pos = (pos + 7) % 8;  
}

void rotate_ccw(int& pos) {
    pos = (pos + 1) % 8; 
}

void check_() {
    for (int i = 1; i < 4; i++) {
        point[i] = (cw[i][(position[i] + 2) % 8] != cw[i + 1][(position[i + 1] + 6) % 8]);
    }
}

void left_check(int idx, int d) {
    if (idx <= 1) return;  
    if (point[idx - 1]) {
        isRotate[idx - 1] = d * -1; 
        left_check(idx - 1, d * -1);  
    }
}

void right_check(int idx, int d) {
    if (idx >= 4) return;  
    if (point[idx]) {
        isRotate[idx + 1] = d * -1;  
        right_check(idx + 1, d * -1);  
    }
}

void roll(int num, int mg) {
    isRotate[num] = mg;

    left_check(num, mg);
    right_check(num, mg);

    for (int i = 1; i <= 4; i++) {
        if (isRotate[i] == 1) {
            rotate_cw(position[i]);  
        } else if (isRotate[i] == -1) {
            rotate_ccw(position[i]);  
        }
    }
}

int main() {
    for (int i = 1; i <= 4; i++) {
        for (int j = 0; j < 8; j++) {
            cin >> c;
            cw[i][j] = c - '0';
        }
    }
    cin >> test;
    for (int i = 0; i < test; i++) {
        cin >> num >> mg;
        
        //초기화
        fill(isRotate, isRotate + 5, 0);

        check_(); 
        roll(num, mg);  
    }

    if (cw[1][position[1]] == 1) score += 1;
    if (cw[2][position[2]] == 1) score += 2;
    if (cw[3][position[3]] == 1) score += 4;
    if (cw[4][position[4]] == 1) score += 8;
    
    cout << score << '\n';

    return 0;
}