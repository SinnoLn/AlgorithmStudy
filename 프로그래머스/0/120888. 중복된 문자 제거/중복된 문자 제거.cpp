#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<char> v;
string solution(string my_string) {
    string answer="";
    for(int i=0; i<my_string.size(); i++){
        if(find(v.begin(),v.end(),my_string[i]) == v.end()){
            v.push_back(my_string[i]);
        } 
        else my_string.replace(i,1,"0");
    }
    for(int i=0; i<my_string.size(); i++){
        if(my_string[i] != '0'){
            answer+=my_string[i];
        } 
    }
    return answer;
}