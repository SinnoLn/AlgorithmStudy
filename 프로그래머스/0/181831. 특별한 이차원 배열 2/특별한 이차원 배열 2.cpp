#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<vector<int>> arr) {
    int answer = 1;
    for(int i=0; i<arr.size(); i++){
        for(int j=0; j<arr.size(); j++){
            if(arr[i][j] != arr[j][i]){
                // cout << arr[i][j] <<" : "<<arr[j][i]<<'\n';
                // cout << "i :" <<i <<" "<< " j : " <<j <<'\n';
                answer = 0;
                break;
            }
        }
    }
    return answer;
}