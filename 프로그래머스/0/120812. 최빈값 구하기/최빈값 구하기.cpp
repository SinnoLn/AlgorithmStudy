#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int d[1000], num, prenum;
int solution(vector<int> array) {
    int answer = 0;
    for(int i=0; i<array.size(); i++){
        d[array[i]]++;
    }
    
    for(int i=0; i<1000; i++){
        if(num < d[i]){
           num = d[i];
           prenum = i;
        }
    }
    sort(d, d + 1000, greater<int>());
    if((d[0] == d[1])) answer = -1;
    else answer = prenum;
    return answer;
}