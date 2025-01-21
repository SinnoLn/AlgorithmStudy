#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>
using namespace std;

unordered_map<string,int> total_listening;
unordered_map<string, vector<pair<int, int>>> genre_index;

bool cmp_genre(const pair<string, int>& a, const pair<string, int>& b) {
    return a.second > b.second;
}
bool cmp_genre_index(const pair<int, int>& a, const pair<int, int>& b) {
    if(a.first == b.first) return a.second < b.second;
    return a.first > b.first;
    
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    for(int i=0; i<genres.size(); i++){
         total_listening[genres[i]] += plays[i];
         genre_index[genres[i]].push_back({plays[i],i});
    }
    
    vector<pair<string,int>> sorted_genre;
    for(auto& iter : total_listening){
        sorted_genre.push_back({iter.first, iter.second});
    }
    sort(sorted_genre.begin(), sorted_genre.end(), cmp_genre);
    
    for(auto& iter : genre_index){
        sort(iter.second.begin(), iter.second.end(), cmp_genre_index);
    }
    
    for(int i=0; i<sorted_genre.size(); i++){
        string curr_genre = sorted_genre[i].first;
        for(int j=0; j<2; j++){
            if(genre_index[curr_genre].size() == 1) {
                answer.push_back(genre_index[curr_genre][j].second);
                break;
            }
            answer.push_back(genre_index[curr_genre][j].second);
        }
    }
    
    return answer;
}