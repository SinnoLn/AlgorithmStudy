#include <string>
#include <iostream>

using namespace std;
long long sum;
long long solution(int price, int money, int count)
{
    long long answer = 0;
    for(int i=1; i<=count; i++){
        sum += price*i;
    }
    answer = money - sum;
    if(answer >= 0)
        answer = 0;
    else
        answer *= -1;
    return answer;
}