#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int max_num = -2100000000;
int solution(vector<int> numbers) {
    for(int i=0; i<numbers.size()-1; i++){
        for(int j=i+1; j<numbers.size(); j++){
            max_num = max(max_num , numbers[i]*numbers[j]);
        }
    }
    return max_num;
}