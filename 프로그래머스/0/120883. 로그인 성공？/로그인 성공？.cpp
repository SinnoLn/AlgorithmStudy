#include <string>
#include <vector>

using namespace std;

string solution(vector<string> id_pw, vector<vector<string>> db) {
    string answer = "fail";
    for(const auto& account : db){
        if(account[0] == id_pw[0]){
            if(account[1] == id_pw[1]) answer = "login";
            else answer = "wrong pw";
        }
    }
    return answer;
}