#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(vector<vector<int>> dots) {
    for(int a=0; a<4; a++){
        for(int b=a+1; b<4; b++){
            for(int c=0; c<4; c++){
                if(c==a || c==b) continue;
                for(int d=c+1; d<4; d++){
                    if(d==a || d==b) continue;
                    int dy1 = dots[b][1] - dots[a][1];
                    int dx1 = dots[b][0] - dots[a][0];
                    int dy2 = dots[d][1] - dots[c][1];
                    int dx2 = dots[d][0] - dots[c][0];
                    if (dy1 * dx2 == dy2 * dx1) return 1;
                }
            }
        }
    }
    return 0;
}