#include <bits/stdc++.h>
using namespace std;

map<int, int> mp;
vector<int> v;
int num;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 1; i <= 30; i++)
        mp[i] = 1;

    for (int j = 0; j < 28; j++)
    {
        cin >> num;
        mp[num] = 0;
    }

    for (auto it : mp)
        if (it.second)
            cout << it.first << '\n';

    return 0;
}