#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    int tmp = 0;
    string string_x = to_string(x);
    for(char c : string_x){
        tmp+=c-'0';
    }
    if(x%tmp == 0) return true;
    else return false;
}