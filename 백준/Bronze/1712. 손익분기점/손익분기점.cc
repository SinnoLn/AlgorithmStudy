#include <iostream>

using namespace std;

int a, b, c, tmp;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> a >> b >> c;

    if (b >= c)
    {
        cout << -1 << '\n';
        return 0;
    }
    else
    {
        tmp = (a / (c - b)) + 1;
        cout << tmp << '\n';
    }
    return 0;
}