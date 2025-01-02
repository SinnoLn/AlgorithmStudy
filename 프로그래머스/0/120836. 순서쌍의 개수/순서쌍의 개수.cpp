#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    int num = sqrt(n);
    for(int i=1; i<=num; i++){
        if(n%i == 0) answer+=2;
    }
    if(num*num == n)answer--;
    return answer;
}