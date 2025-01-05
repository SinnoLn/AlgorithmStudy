#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "Yes";
    int cards1_position = 0, cards2_position = 0;
    
    for(string s : goal){
        if(s == cards1[cards1_position]) cards1_position++;
        else if(s == cards2[cards2_position]) cards2_position++;
        else {
            answer = "No";
            break;
        }
    }
    return answer;
}