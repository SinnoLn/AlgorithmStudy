/*
   Disjoint-set data structure
*/
#include <iostream>
#define MAX_NUM 500000  
using namespace std;

int n, m, p[MAX_NUM], a, b, ans;
bool _union(int v, int u);
int find(int v);

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;

    for(int i=0; i<n; i++)
        p[i] = i;

    for(int i=1; i<=m; i++){
        cin >> a >> b;
        
        if(find(a) == find(b)){
            ans = i;
            break;
        }
        _union(a,b);
    }

    cout << ans << '\n';
    return 0;
}


bool _union(int v, int u) {
    v = find(v);
    u = find(u);
    
    //이미 같은 집합인 경우
    if(v == u) 
        return false;
    
    //서로 다른 집한인 경우
    if(v<u) p[v] = u;
    else p[u] = v;
    return true;
}

int find(int v) {
    if(v == p[v])
        return v;
    return p[v] = find(p[v]);
}