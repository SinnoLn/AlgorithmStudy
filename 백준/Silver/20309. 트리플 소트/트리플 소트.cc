#include <iostream>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, m;
    bool ans = true;
    cin >> n;
    
    for(int i=1; i<=n; i++)
    {
        cin>>m;
        if(i%2 != m%2)
        {
            ans = false;
            break;
        }
    }
    
    if(ans)
    cout<<"YES"<<'\n';
    else
    cout<<"NO"<<'\n';
    
    return 0;
}
