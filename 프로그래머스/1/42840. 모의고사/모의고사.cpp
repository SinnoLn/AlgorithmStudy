#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
int s1[5] = {1,2,3,4,5};
int s2[8] = {2,1,2,3,2,4,2,5};
int s3[12] = {3,3,1,1,2,2,4,4,5,5};
vector<pair<int,int>> cor;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    for(int i=1; i<=3; i++){
        cor.push_back({0,i});
    }
    for(int i=0; i<answers.size(); i++){
        if(answers[i] == s1[i%5]) cor[0].first++;
        if(answers[i] == s2[i%8]) cor[1].first++;
        if(answers[i] == s3[i%10]) cor[2].first++;
    }
    
    sort(cor.begin(), cor.end(), [](pair<int,int>a, pair<int,int>b){
		    if(a.first == b.first)
			    return a.second < b.second;
			   return a.first > b.first;
    });

    answer.push_back(cor[0].second);
    for(int i=1; i<cor.size(); i++){
        if(cor[0].first == cor[i].first)
            answer.push_back(cor[i].second);
    }
    return answer;
}