#include <string>
#include <iostream>
#include <vector>
#include <bitset>

#define MAX_SIZE 16
using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    string s1 ="", s2="";
    for(int i=0; i<n; i++){
        string tmp = "";
        bitset<MAX_SIZE> bit1(arr1[i]);
        bitset<MAX_SIZE> bit2(arr2[i]);
        
        s1 = bit1.to_string();
        s2 = bit2.to_string();
        
        for(int i=MAX_SIZE-n; i<MAX_SIZE; i++){
            if(s1[i] == '1' || s2[i] == '1') tmp+="#";
            else tmp+=" ";
        }
        answer.push_back(tmp);
    }
    return answer;
}