#include <string>
#include <vector>
#include <stack>
#include <algorithm>

using namespace std;
stack<int> basket;
vector<vector<int>>tmpstack;
int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    for(int i=0; i<board.size(); i++){
        vector<int> tmp;
        for(int j=0; j<board.size(); j++){
            if(board[j][i]!= 0) tmp.push_back(board[j][i]);
        }
        reverse(tmp.begin(), tmp.end());
        tmpstack.push_back(tmp);
    }
    
    for(int i : moves){
        if(tmpstack[i-1].size() != 0){
            int picknum = tmpstack[i-1].back();
            tmpstack[i-1].pop_back();

            if(!basket.empty()){
                if(basket.top() == picknum){
                    basket.pop();
                    answer+=2; //사라지는 인형 기준
                }
                else basket.push(picknum);
            }
            else basket.push(picknum);
        }
    }
    return answer;
}