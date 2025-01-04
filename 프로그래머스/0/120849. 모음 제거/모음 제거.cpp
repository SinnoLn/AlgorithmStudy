#include <string>
#include <vector>

using namespace std;
string s = "aeiou";
string solution(string my_string) {
    for(char c : s){
        while(my_string.find(c) != string::npos){
            int pos = my_string.find(c);
            my_string.erase(pos, 1);
        }
    }
    return my_string;
}