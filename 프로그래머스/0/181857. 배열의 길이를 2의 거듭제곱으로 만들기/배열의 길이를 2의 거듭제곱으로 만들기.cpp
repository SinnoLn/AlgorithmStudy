#include <string>
#include <vector>
#include <iostream>

using namespace std;

//2의 거듭제곱에는 2의 0승도 잇다.
vector<int> solution(vector<int> arr) {
    int size = arr.size();
    int i = 2;
    if(size == 1) return arr;
    while(size > i){i*=2;}
    if(size < i) {
        for(int j=0; j<i-size; j++) arr.push_back(0);
    }
    return arr;
}