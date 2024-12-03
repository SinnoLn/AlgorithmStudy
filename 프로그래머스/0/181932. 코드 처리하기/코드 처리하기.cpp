#include <string>
#include <vector>

using namespace std;
int mod,idx;
string solution(string code) {
    string ret = "";
    for(int idx=0; idx<code.size(); idx++){
        
        if(mod == 0){
            if(code[idx] == '1') mod = 1;
            else if (idx%2 == 0) ret+=code[idx]; 
        }
        else if(mod == 1){
            if(code[idx] == '1') mod = 0;
            else if (idx%2 == 1) ret+=code[idx];
        }
    }
    
    if(ret.empty()) ret = "EMPTY";
    return ret;
}