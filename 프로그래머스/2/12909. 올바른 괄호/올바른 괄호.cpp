#include<string>
#include <iostream>
#include <stack>

using namespace std;

stack<int> st;
bool solution(string s)
{
    bool answer = true;
    
    for(char c : s){
        if(c == '('){
            st.push(1);
        }
        else if(c == ')'&& !st.empty()){
            st.pop();
        }
        else return false;
        
    }
    
    if(!st.empty()) return false;

    return true;;
}