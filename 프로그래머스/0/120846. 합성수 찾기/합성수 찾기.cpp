#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    for(int i=3; i<=n; i++){
        for(int j=2; j<i; j++){
            if(i%j == 0){
                answer++;
                break;
            }
        }
    }
    return answer;
}