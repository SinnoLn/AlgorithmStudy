#include <bits/stdc++.h>
using namespace std;

long long int diff;
long long int n, m;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;
    diff = n - m;

    if (diff < 0)
        diff = diff * (-1);

    cout << diff << '\n';

    return 0;
}