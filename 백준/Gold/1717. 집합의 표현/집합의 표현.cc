//find 효율적으로 구현하기
//집합이므로 부분집합 V는 원소수 +1임을 잊지말기
//0부터 집합 시작이라고 되어있음

#include <iostream>

using namespace std;

const int V = 1000001;
int n, m, a, b, p[V], o;
int find(int a);
bool _union(int v, int u);

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    //자기 자신으로 집합 초기화
    for(int i=0; i<=n; i++){
        p[i] = i;
    }
    
    for(int i=0; i<m; i++){
        cin >> o >> a >> b;
        if(o == 0) 
            _union(a, b);
        else{
            if(find(a) == find(b))
                cout<<"YES"<<'\n';
            else
                cout<<"NO"<<'\n';
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