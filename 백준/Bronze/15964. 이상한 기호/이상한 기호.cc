#include <bits/stdc++.h>
using namespace std;

int a, b, result;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> a >> b;
    result = (a + b) * (a - b);
    cout << result << '\n';

    return 0;
}