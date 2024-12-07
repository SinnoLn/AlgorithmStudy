#include <string>
#include <vector>

using namespace std;

int solution(int price) {
    int answer = price;
    if(price >= 500000) answer-=price*0.2;
    else if(price >= 300000) answer-=price*0.1;
    else if(price >= 100000) answer-=price*0.05;
    return answer;
}