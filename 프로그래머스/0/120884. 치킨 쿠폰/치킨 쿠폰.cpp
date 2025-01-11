#include <string>
#include <vector>

using namespace std;

int service, coupon, tmp;
int solution(int chicken) {
    coupon = chicken;
    while(coupon >= 10){
        service+=coupon/10;
        coupon = coupon/10 + coupon%10;
    }
    return service;
}