#include <string>
#include <vector>

using namespace std;

int answer;
void dfs(vector<int>& numbers, int target, int index, int sum);
int solution(vector<int> numbers, int target) {
    dfs(numbers,target,0,0);
    return answer;
}

void dfs(vector<int>& numbers, int target, int index, int sum){
    if(index == numbers.size()){
        if(sum == target) answer++;
        return;
    } 
    dfs(numbers,target,index+1,sum+numbers[index]);
    dfs(numbers,target,index+1,sum-numbers[index]);
}