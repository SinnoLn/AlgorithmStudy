#include <iostream>
#include <algorithm>
#define MAX_NUM 1000000

using namespace std;
int n, num, p[MAX_NUM], size;

int main(){

    cin >> n;

    for(int i=0; i<n; i++){
        cin >> num;
        p[i] = num;
    }

    sort(p, p+n);

    for(int i=0; i<n; i++){
        cout << p[i] << '\n';
    }

    return 0;
}