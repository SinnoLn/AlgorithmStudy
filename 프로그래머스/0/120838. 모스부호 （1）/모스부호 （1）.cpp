#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;
string morse[26] = { 
    ".-","-...","-.-.","-..",".","..-.",
    "--.","....","..",".---","-.-",".-..",
    "--","-.","---",".--.","--.-",".-.",
    "...","-","..-","...-",".--","-..-",
    "-.--","--.."};
string dic[26] ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

string solution(string letter) {
    string answer = "";
    stringstream ss(letter);
    string s1;
    while(ss >> s1){
        int po =find(morse, morse+26, s1) - morse;
        answer+=dic[po];
    }
    return answer;
}