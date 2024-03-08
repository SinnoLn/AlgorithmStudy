#include <bits/stdc++.h>
using namespace std;
int graphBFS[101][101];
bool visited[101];
int countNum;
void dfs(int node, int n);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int node, link, i, j;
    cin >> node >> link;

    for (int m = 0; m < link; m++)
    {
        cin >> i >> j;
        graphBFS[i][j] = 1;
        graphBFS[j][i] = 1;
    }

    dfs(1, node);
    cout << countNum << '\n';

    return 0;
}

void dfs(int node, int n)
{
    visited[node] = true;
    for (int k = 1; k <= n; k++)
    {
        if (!visited[k] && graphBFS[node][k] == 1)
        {
            countNum++;
            dfs(k, n);
        }
    }
}