#include <bits/stdc++.h>
using namespace std;

map<string, string> sites;
string a, b, finds;

int n, m;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        cin >> a >> b;
        sites[a] = b;
    }

    for (int i = 0; i < m; i++)
    {
        cin >> finds;
        if (sites.find(finds) != sites.end())
        {
            cout << sites[finds] << endl;
        }
    }
    return 0;
}