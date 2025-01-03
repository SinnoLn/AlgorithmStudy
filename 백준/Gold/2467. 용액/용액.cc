#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

int n, liquid[100000], answer[2];
int main() {
    cin >> n;
    for(int i=0; i<n; i++) cin >> liquid[i]; 
    int min_num = 2100000000;
    int left = 0, right = n-1;
    
    while(left < right){
      if(min_num>abs(liquid[left]+liquid[right])){
            min_num = abs(liquid[left]+liquid[right]);
            answer[0] = liquid[left];
            answer[1] = liquid[right];
        } 
        
        if(liquid[left]+liquid[right]<0) left++;
        else if(liquid[left]+liquid[right]>0) right--;
        else break;
    }
    cout << answer[0] <<" "<<answer[1]<<'\n';
    return 0;
}