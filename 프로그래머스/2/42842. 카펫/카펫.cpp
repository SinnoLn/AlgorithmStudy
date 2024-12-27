#include <string>
#include <vector>

using namespace std;

//최대 10000*10000 이하면 가능
vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    for(int i=3; i<=2500; i++){ //가로
        for(int j=3; j<=2500; j++){ //세로
            if(((i-2)*(j-2) == yellow) && (brown+yellow) == i*j && i>=j){
                answer.push_back(i);
                answer.push_back(j);
                break;
            } 
        }
    }
    return answer;
}