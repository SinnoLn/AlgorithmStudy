#include <string>
#include <vector>

using namespace std;

int solution(int n, string control) {
    for(char c : control){
        if(c == 'w')
            n++;
        else if(c == 's')
            n--;
        else if(c == 'd')
            n+=10;
        else
            n-=10;
    }
    return n;
}