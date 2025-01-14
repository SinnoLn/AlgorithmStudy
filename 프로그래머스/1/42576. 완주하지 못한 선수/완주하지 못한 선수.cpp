#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string,int> names;
string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    for(int i=0; i<completion.size(); i++){
        names[participant[i]]++;
        names[completion[i]]--;
    }
     names[participant[participant.size()-1]]++;
    
    for(auto iter = names.begin(); iter != names.end(); iter++){
        if(iter->second != 0){
            answer = iter->first;
            break;
        } 
    }
    return answer;
}