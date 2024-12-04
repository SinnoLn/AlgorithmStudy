#include <string>
#include <vector>

using namespace std;
int solution(int num) {
    int answer = 0;
     if (num == 1) return 0;
     while(1){
        if(answer == 500){
            answer = -1;
            break;
        }
        
        answer++;
        if(num%2==0) num/=2;
        else if(num%2==1) num = num*3+1;
        
        if(num == 1) break;
    }
    return answer;
}