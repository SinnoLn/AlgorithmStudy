#include <string>
#include <vector>

using namespace std;
vector<vector<int>> moves;

void move(int disk, int start, int end){
    moves.push_back({start,end});
}

void hanoi(int n, int start, int end, int sub){
    if(n==1){
        move(1, start, end);
        return;
    }
    hanoi(n-1, start, sub, end);
    move(n, start, end);
    hanoi(n-1, sub, end, start);
}

//하노이의 탑 (대표적인 재귀 문제)
vector<vector<int>> solution(int n) {
    moves.clear();
    hanoi(n,1,3,2);
    return moves;
}

