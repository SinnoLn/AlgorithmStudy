#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string new_id) {
    string answer = "";
    string tmp = "";
    //1단계&&2단계
    for(char c : new_id){
        if(c == '-'|| c=='_' || c=='.' || (c>='0' && c<='9')) answer+=c;
        if(c >= 'A' && c<= 'Z') answer+= c+32;
        if(c >= 'a' && c<= 'z') answer+=c;
    }
    
    //3단계
    tmp+=answer[0];
    for(int i=1; i <answer.size(); i++){
        if(answer[i] == '.'&& answer[i-1] == '.') continue;
        tmp+=answer[i];
    }
    
    //4단계
    if(tmp[0] == '.') tmp.erase(0,1);
    if(tmp[tmp.size()-1] == '.') tmp.pop_back();
    
    //5단계
    if(tmp.size() == 0) tmp+='a';
    
    //6단계
    if(tmp.size() >= 16) tmp = tmp.substr(0,15);
    if(tmp[tmp.size()-1] == '.') tmp.pop_back();
    
    
    //7단계
    if(tmp.size() <= 2){
        char c = tmp[tmp.size()-1];
        while(tmp.size() != 3) tmp+=c;
    }
    
    return tmp;
}