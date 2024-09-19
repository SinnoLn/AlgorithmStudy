//최소비용 출력
#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>

#define MAX_NUM 1000
using namespace std;

int n, m, a, b, c, p[MAX_NUM], sum;
vector<tuple<int, int, int>> vt;
int find(int v);
bool _union(int v, int u);

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    cin >> m;

    for(int i=1; i<=n; i++)
        p[i] = i;

    for(int i =0; i<m; i++)
    {
        cin >> a >> b >> c;
        vt.push_back(make_tuple(c, a, b));
    }

    sort(vt.begin(), vt.end());

    for(int i=0; i<m; i++)
    {
        int q,w,e;
        tie(q,w,e) = vt[i];

        if(find(w) != find(e)){
            _union(w,e);
            sum += q;
        }
    }

    cout <<sum << '\n';

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