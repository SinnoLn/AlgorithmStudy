#include <string>
#include <vector>

using namespace std;
//피자수와 사람의 최소공배수
int solution(int n) {
    int pizza = 1;
    while(1){
        if((6*pizza)%n==0)break;
        pizza++;
    }
    return pizza;
}