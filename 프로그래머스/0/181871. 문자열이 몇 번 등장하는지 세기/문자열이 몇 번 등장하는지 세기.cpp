#include <string>
#include <vector>

using namespace std;

int solution(string myString, string pat) {
    int answer = 0, pos = 0;
    while(myString.find(pat) != string::npos){
        pos = myString.find(pat);
        if(pat.length() == 1){
            myString.erase(0,pos+pat.length());
        }
        else{
            myString.erase(0,pos+1);
        }

        answer++;
    }
    return answer;
}