/*
! 좌표 정렬하기 2 (백준 11651)
 */
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, x, y;
vector<pair<int, int>> v;

int main() {
    cin >> n;

    for(int i=0; i<n; i++){
        cin >> y >> x;
        v.push_back({x,y});
    }

    sort(v.begin(), v.end());

    for(auto i: v)
        cout << i.second << " " << i.first << '\n'; 
        
    return 0;
}