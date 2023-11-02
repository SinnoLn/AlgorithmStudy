#include <iostream>
#include <map>
#include <algorithm>

using namespace std;
int n, m, num;
map<int, int> mp;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> num;
        mp[num]++;
    }

    cin >> m;

    for (int j = 0; j < m; j++)
    {
        cin >> num;
        if (mp.find(num) != mp.end())
            cout << 1 << '\n';
        else
            cout << 0 << '\n';
    }

    return 0;
}