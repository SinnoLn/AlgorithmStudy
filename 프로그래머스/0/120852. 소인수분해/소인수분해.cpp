#include <string>
#include <algorithm>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    int tmp = 1;
    int tmp2 = n;
    while(n != tmp){
        for(int i=2; i<=tmp2; i++){
            if(tmp2%i == 0){
                tmp2/=i;
                tmp*=i;
                if(find(answer.begin(), answer.end(), i) == answer.end()){
                    answer.push_back(i);
                }
                break;
            }
        }
    }
    return answer;
}