#include <string>
#include <vector>
#include <iostream>

using namespace std;
int solution(vector<int> arr) {
    vector<int> tmp;
    int answer =0;
    for(int i=0; i<arr.size(); i++) tmp.push_back(arr[i]);
    
    while(1){
        answer++;
        for(int i=0; i<arr.size(); i++){
            if(tmp[i] >= 50 && tmp[i]%2==0){
                arr[i] = tmp[i];
                tmp[i]/=2;
            }
            else if(tmp[i] < 50 && tmp[i]%2==1){
                arr[i] = tmp[i];
                tmp[i]=tmp[i]*2+1;
            } 
            else arr[i] = tmp[i];
        }
        
        // for(int i=0; i<arr.size(); i++) cout << arr[i] <<" ";
        // cout << '\n';
        
        bool chk = true;
        for(int i=0; i<arr.size(); i++){            
            if(arr[i] != tmp[i]) chk = false;
        }
        if(chk) break;  
    }
    return answer-1;
}