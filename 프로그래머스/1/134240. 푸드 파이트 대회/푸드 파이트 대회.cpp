#include <string>
#include <vector>
#include <algorithm>

using namespace std;
string rans = "";
string solution(vector<int> food) {
    string answer = "";
    for(int i=1; i<food.size(); i++){
        for(int j=0; j<food[i]/2; j++){
            answer+=to_string(i);
        } 
    }
    rans = answer;
    reverse(rans.begin(), rans.end());
    answer+="0";
    answer+=rans;
    return answer;
}