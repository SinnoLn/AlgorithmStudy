#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int dir[31];
int solution(vector<string> strArr) {
    for(int i=0; i<strArr.size(); i++){
        dir[strArr[i].size()]++;
    }
    
    sort(dir, dir+31, greater<>{});
    
    return dir[0];
}