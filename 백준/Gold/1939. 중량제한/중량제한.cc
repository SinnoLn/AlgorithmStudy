#include <iostream>
#include <vector>
#include <climits>
#include <queue>

using namespace std;

int n, m, a, b, c;
int s, e;
int l , ans, r = INT_MAX;

bool wchk(vector<vector<pair<int, int>>>& graph, int n, int s, int e, int w){

    queue<int> q;
    q.push(s);
    vector<int> chk(n+1);

    while(!q.empty()) {
        int curr = q.front();
        q.pop();
        if(chk[curr] == 1) continue;
        chk[curr] = 1;

        if(curr == e)
            return true;
        
        for(size_t i = 0; i< graph[curr].size(); i++){
            if(graph[curr][i].second >= w)
                q.push(graph[curr][i].first);
        }
    }

    return false;

}

int main() {
    cin >> n >> m;

    vector<vector<pair<int,int>>> graph(n+1);

    for(int i=0; i<m; i++)
    {
        cin >> a >> b>> c;
        graph[a].push_back({b,c});
        graph[b].push_back({a,c});
    }

    cin >>s>> e;

    while(l != r) {
        int mid = r - (r-l) /2;

        if(wchk(graph, n, s, e, mid))
            l = mid;
        else
            r = mid - 1;
    }
    cout << l;
}

