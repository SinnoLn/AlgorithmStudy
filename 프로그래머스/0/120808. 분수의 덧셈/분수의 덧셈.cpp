#include <string>
#include <vector>

using namespace std;
int gcd(int a, int b);
int lcm(int a, int b);

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
    vector<int> answer;
    int tmp1 = lcm(denom1, denom2);
    int tmp2 = (tmp1/denom1)*numer1 + (tmp1/denom2)*numer2;
    
    //기약분수로 나타내기 위해 최대공약수 구함
    int tmp3 = gcd(tmp2, tmp1);
    
    answer.push_back(tmp2/tmp3);
    answer.push_back(tmp1/tmp3);
    return answer;
}

//최대공약수 구하기
int gcd(int a, int b){
    int c;
    while(b != 0){
        c = a%b;
        a = b;
        b = c;
    }
    return a;
}

//최소 공배수 구하기
int lcm(int a, int b){
    return a*b /gcd(a,b);
}