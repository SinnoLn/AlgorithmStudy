#include <iostream>
#include <algorithm>
using namespace std;

string s, rs;
int main()
{
    cin >> s;
    rs = s;
    reverse(rs.begin(), rs.end());

    if (s == rs)
        cout << 1 << '\n';
    else
        cout << 0 << '\n';

    return 0;
}