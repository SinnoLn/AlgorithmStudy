#include <string>
#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

int x, y;
vector<int> solution(vector<string> keyinput, vector<int> board) {
    vector<int> answer;
    int board_col = board[0]/2;
    int board_row = board[1]/2;
    
    cout << board_col << " : " << board_row <<'\n';

    
    for(string s : keyinput){
        if(s == "up"){
            if(abs(y+1) > board_row) continue;
            y+=1;
        }
        else if(s == "down"){
            if(abs(y-1) > board_row) continue;
            y-=1;
        }
        else if(s == "left"){
            if(abs(x-1) > board_col) continue;
            x-=1;
        }
        else{
            if(abs(x+1) > board_col) continue;
            x+=1;
        }
    }
    answer.push_back(x);
    answer.push_back(y);
    return answer;
}