#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr, vector<int> query) {
    for(int i=0; i<query.size(); i++){
        if(i%2==0){
            arr.erase(arr.begin()+query[i]+1, arr.end());
        }
        else if(i%2==1){
            arr.erase(arr.begin(),arr.begin()+query[i]);
        }
    }
    return arr;
}