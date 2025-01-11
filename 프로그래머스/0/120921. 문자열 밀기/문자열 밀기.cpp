#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string A, string B) {
    int answer = 0;
    for(int i=0; i<A.size(); i++){
        if(A == B) break;
        char tmp = A[A.size()-1];
        A.erase(A.size()-1,1);
        A.insert(A.begin(),tmp);
        answer++;
    }
    
    if(answer == A.size()) return -1;
    else return answer;
}