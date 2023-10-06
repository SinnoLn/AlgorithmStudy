#include <bits/stdc++.h>
using namespace std;
int n, level, opinion, ex;
float point;
vector<int> op;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    if (n == 0)
    {
        cout << 0 << endl;
        return 0;
    }

    ex = round(n * (0.15));

    for (int i = 0; i < n; i++)
    {
        cin >> opinion;
        op.push_back(opinion);
    }

    sort(op.begin(), op.end());

    for (int j = ex; j < n - ex; j++)
    {
        point += op[j];
    }
    level = round(point / (n - (2 * ex)));
    cout << level << endl;

    return 0;
}
