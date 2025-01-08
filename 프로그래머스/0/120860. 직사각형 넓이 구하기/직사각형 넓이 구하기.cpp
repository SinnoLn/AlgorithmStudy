#include <string>
#include <vector>
#include <cmath>

using namespace std;

int width, height;
int solution(vector<vector<int>> dots) {
    int answer = 0;
    for(int i=1; i<4; i++){
        if((dots[0][0] - dots[i][0]) != 0) width = abs(dots[0][0] - dots[i][0]);
        if((dots[0][1] - dots[i][1]) != 0) height = abs(dots[0][1] - dots[i][1]);
    }
    answer = width*height;
    return answer;
}