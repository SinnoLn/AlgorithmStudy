#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string letter) {
    while(1){
        int po = my_string.find(letter);
        if(po == string::npos) break;
        else my_string.erase(po,1);
    }
    return my_string;
}