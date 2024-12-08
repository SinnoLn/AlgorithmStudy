#include <string>
#include <vector>

using namespace std;

int solution(int n, int k) {
    int answer = 0;
    k-=(n/10);
    answer = n*12000 + k*2000;
    return answer;
}