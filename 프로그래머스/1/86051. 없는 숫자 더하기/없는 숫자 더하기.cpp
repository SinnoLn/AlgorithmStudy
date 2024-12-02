#include <string>
#include <vector>

using namespace std;
int number[10]; //1부터 10까지 사용

int solution(vector<int> numbers) {
    int answer = 0;
    for(int i=0; i<numbers.size(); i++){
        if(number[numbers[i]] == 0)
            number[numbers[i]] = 1;
    }
    for(int i=0; i<10; i++){
        if(number[i] == 0)
            answer+=i;
    }
    return answer;
}