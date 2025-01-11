#include <string>
#include <vector>

using namespace std;

vector<int> hamburger;
int solution(vector<int> ingredient) {
    int answer = 0;
    
    for(int item : ingredient){
        hamburger.push_back(item);
        int size = hamburger.size();
        
        if(size>=4){
            if(hamburger[size-4] == 1 &&
            hamburger[size-3] == 2 &&
            hamburger[size-2] == 3 &&
            hamburger[size-1] == 1){
                hamburger.pop_back();
                hamburger.pop_back();
                hamburger.pop_back();
                hamburger.pop_back();
                answer++;
            }
        }
    }
    return answer;
}