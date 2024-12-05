#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    //이 while문이 절대로 1보다 작아질 수없음
    //1일 경우 1 = 1*3+1로 4가 되어 무한반복문이 되어버림
    while(n != 1){
        answer.push_back(n);
        if(n%2 == 0) n/=2;
        else if (n%2 == 1) n = n*3+1;
    }
    answer.push_back(1);
    return answer;
}