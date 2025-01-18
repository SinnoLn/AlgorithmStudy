#include <string>
#include <vector>
#include <set>
#include <iostream>

using namespace std;

int answer;
bool visited[7];
set<int> results;
bool check_decimal(int i);
void dfs(string numbers, string current);
int solution(string numbers) {
    dfs(numbers, "");
    for(int i : results) if(check_decimal(i))answer++;
    return answer;
}

void dfs(string numbers, string current){
    if(!current.empty()) results.insert(stoi(current));
    
    for(int i=0; i<numbers.length(); i++){
        if(visited[i]) continue;
        
        visited[i] = true;
        dfs(numbers, current+numbers[i]);
        visited[i] = false;
    }
}
bool check_decimal(int i){
    if(i==0) return false;
    if(i==1) return false;
    if(i==2) return true;
    else {
        for(int k=2; k<i; k++) {
            if(i%k==0) return false;
        };
        return true;
    }
}