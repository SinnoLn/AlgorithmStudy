#include <string>
#include <vector>

using namespace std;

vector<int> solution(int num, int total) {
    vector<int> answer;
    int mid = total/num;
    if(total%num == 0){
        for(int i=mid-(num-1)/2; i<=mid+(num-1)/2; i++){
            answer.push_back(i);
        }
    }
    else{
        for(int i=mid-(num/2)+1; i<=mid+(num/2); i++){
            answer.push_back(i);
        }
    }
    return answer;
}