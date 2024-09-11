#include <iostream>

using namespace std;

int n,m,st,en,num;
int sum[100001]; 

int main(){

    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    sum[0] = 0;

    for(int i=1; i<=n; i++)
    {
        cin >> num;
        sum[i] = sum[i-1] + num;
    }
    for(int i=0; i<m; i++){
        cin >> st >> en;
        cout << sum[en] - sum [st-1] <<'\n';
    }
    return 0;
}