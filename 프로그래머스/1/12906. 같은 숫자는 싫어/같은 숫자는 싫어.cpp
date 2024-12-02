#include <vector>
#include <iostream>

using namespace std;
int memory;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    memory = arr[0];
    answer.push_back(arr[0]);
    for(int i=1; i<arr.size(); i++){
        if((memory == arr[i])) continue; //이전꺼랑 겹치면 넘기고
        else if(memory != arr[i]){ //이전꺼랑 안겹치면 넣고
            answer.push_back(arr[i]);
        }
        memory = arr[i];
    }
    

    return answer;
}