#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    string s ="";
    while(n>0){
        s+=to_string(n%3);
        n/=3;
    }
    
    answer = s[0] - '0';
    for(int i=1; i<s.size(); i++){
        answer = answer*3+(s[i] - '0');
    }
    return answer;
}