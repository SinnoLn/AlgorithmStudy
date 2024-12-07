#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string my_string, vector<int> indices) {
    string answer = "";
    for(int i=0; i<indices.size(); i++) {;        
        my_string.replace(indices[i],1, "0");
    }
    
    for(int i=0; i<my_string.size(); i++) {;        
        if(my_string[i] == '0') continue;
        answer+=my_string[i];
    }
    return answer;
}