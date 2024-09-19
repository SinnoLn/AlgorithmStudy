// 여러분들의 다리가 되어드리겠습니다.
// 1. union find로 구현하자
#include <iostream>
#define MAX_NUM 300000

using namespace std;

int n, p[MAX_NUM], a, b, ans;
bool _union(int v, int u);
int find(int v);

int main(){

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for(int i=1; i<=n; i++)
        p[i] = i;

    for(int i=0; i<n-2; i++){
        cin >> a >> b;
        _union(a, b);
    }
    
    ans = find(1);
    
    for(int i=2; i<=n; i++){
        if(ans != find(i)){
            cout << ans << " " << i << '\n';
            break;
        }
    }

    
    return 0;
}

//집합의 대표값 찾기
int find(int v) {
    if(v == p[v])
        return v;
    return p[v] = find(p[v]);
}

//집합을 합치는 연산
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