#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, int k) {
    vector<int> answer;
    if(k%2==0){
        for(int i=0; i<arr.size(); i++) arr[i]+=k;
    }
    else if(k%2==1){
        for(int i=0; i<arr.size(); i++) arr[i]*=k;
    }
    return arr;
}