#include <string>
#include <vector>

using namespace std;

string solution(string my_string, string overwrite_string, int s) {
    string answer = "";
    answer = my_string;
    int p = 0;
    for(int i=s; i<overwrite_string.size()+s; i++){
        answer[i] = overwrite_string[p++];
    }
    return answer;
}