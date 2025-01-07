#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string t, string p) {
    int answer = 0;
    long long num = stoll(p);
    int size = p.size();
    for(int i=0; i<t.size()-size+1; i++){
        if(stoll(t.substr(i,size)) <= num) answer++;
    }
    return answer;
}