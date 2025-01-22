#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
#include <algorithm>

using namespace std;

unordered_map<string,pair<int,int>> gift_summary;
unordered_map<string, int> name_to_index;
int gift_matrix[50][50];
string giver, receiver;
int giver_index, receiver_index;

int solution(vector<string> friends, vector<string> gifts) {
    vector<int> next_gift(friends.size());
    
    for(int i=0; i<friends.size(); i++) name_to_index[friends[i]] = i;
    for(string s : gifts){
        stringstream ss(s);
        ss >> giver >> receiver;
        
        giver_index = name_to_index[giver];
        receiver_index = name_to_index[receiver];
        
        gift_matrix[giver_index][receiver_index]++;
        gift_summary[giver].first++;
        gift_summary[receiver].second++;
    }
    
    for(int i=0; i<friends.size()-1; i++){
        for(int j=i+1; j<friends.size(); j++){
            if(gift_matrix[i][j]>gift_matrix[j][i]) next_gift[i]++;
            else if(gift_matrix[i][j]<gift_matrix[j][i]) next_gift[j]++;
            else{
                int gift1 = gift_summary[friends[i]].first-gift_summary[friends[i]].second;
                int gift2 = gift_summary[friends[j]].first-gift_summary[friends[j]].second;
                
                if(gift1 > gift2) next_gift[i]++;
                else if(gift1 < gift2) next_gift[j]++;
                else continue;
            }
        }
    }
    
    sort(next_gift.rbegin(), next_gift.rend());
    return next_gift[0];
}