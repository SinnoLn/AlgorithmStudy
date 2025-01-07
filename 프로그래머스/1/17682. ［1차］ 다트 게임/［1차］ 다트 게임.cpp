#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int>nums;
int next_position, answer, tmp;
string tmps;
int string_to_int(string s);
int solution(string dartResult) {
    for(char c : dartResult){
        if(c == 'S'){
            tmp = string_to_int(tmps);
            nums.push_back(tmp);
            next_position++;
            continue;
        }
        else if(c == 'D'){
            tmp = string_to_int(tmps);
            nums.push_back(tmp*tmp);
            next_position++;
            continue;
        }
        else if (c == 'T'){
            tmp = string_to_int(tmps);
            nums.push_back(tmp*tmp*tmp);
            next_position++;
             continue;
        }
        else if (c == '*'){
            if(next_position-2>=0) nums[next_position-2]*=2;
            nums[next_position-1]*=2;
            continue;
        }
        else if(c == '#'){
            nums[next_position-1]*=-1;
            continue;
        }
        tmps+=c;
    }
    for(int i : nums) answer+=i;
    return answer;
}

int string_to_int(string s){
    int i = 0;
    if(s.size() == 1){
        i = s[0] - '0';
    }
    else i = stoi(s);
    tmps = "";
    return i;
}