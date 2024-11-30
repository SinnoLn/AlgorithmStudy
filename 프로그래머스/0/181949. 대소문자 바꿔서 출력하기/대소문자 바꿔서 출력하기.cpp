#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    for(int i=0; i<str.size(); i++){
        char c = str[i];
        if(97<=c && c<=122){ //소문자일 경우
            c-=32;
            cout << c;
        }
        else if(65<=c && c<=90){ //대문자일 경우
            c+=32;
            cout << c;
        }
    }
    return 0;
}