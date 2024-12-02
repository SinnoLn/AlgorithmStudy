#include <string>
#include <vector>

using namespace std;

int solution(int num1, int num2) {
    int answer = 0;
    float tmp = 0.0;
    tmp = ((float)num1 / (float)num2)*1000;
    answer = tmp;
    return answer;
}