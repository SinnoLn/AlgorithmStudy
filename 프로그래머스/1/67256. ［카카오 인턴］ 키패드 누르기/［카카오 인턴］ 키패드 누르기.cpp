#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

string solution(vector<int> numbers, string hand) {
    int cur_rhand[2] = {3,2}, cur_lhand[2] = {3,0};
    string answer = "";
    for(int i : numbers){
        if(i==1 || i ==4 || i==7){
            answer+='L';
            int y = (i-1)/3;
            cur_lhand[0] = y;
            cur_lhand[1] = 0;
        }
        else if(i==3 || i==6 || i==9) {
            answer+='R';
            int y = (i-3)/3;
            cur_rhand[0] = y;
            cur_rhand[1] = 2;
        }
        else{
            int y = (i-2)/3;
            if(i==0) y = 3;
            int curr_pos[2] = {y,1};
            
            int l_diff = abs(curr_pos[0]-cur_lhand[0]) + abs(curr_pos[1]-cur_lhand[1]);
            int r_diff = abs(curr_pos[0]-cur_rhand[0]) + abs(curr_pos[1]-cur_rhand[1]);
            if(l_diff < r_diff){
                answer+='L';
                cur_lhand[0] = curr_pos[0];
                cur_lhand[1] = curr_pos[1];
            }
            else if(l_diff > r_diff){
                answer+='R';
                cur_rhand[0] = curr_pos[0];
                cur_rhand[1] = curr_pos[1];
            }
            else{
                if(hand == "right"){
                    answer+='R';
                    cur_rhand[0] = curr_pos[0];
                    cur_rhand[1] = curr_pos[1];
                }
                else{
                    answer+='L';
                    cur_lhand[0] = curr_pos[0];
                    cur_lhand[1] = curr_pos[1];
                }
            }
        }
        // cout <<"Lhand : "<<cur_lhand[0] << " : " <<cur_lhand[1] << '\n';
        // cout <<"Rhand : "<<cur_rhand[0] << " : " <<cur_rhand[1] << '\n';
        // cout << "===========================" << '\n'<<'\n';
    }
    return answer;
}