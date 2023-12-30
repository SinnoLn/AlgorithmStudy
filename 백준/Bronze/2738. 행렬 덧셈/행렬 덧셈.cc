#include <iostream>

using namespace std;

int result[100][100];

int n, m, num;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> num;
            result[i][j] = num;
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> num;
            result[i][j] += num;
            cout << result[i][j] << ' ';
        }
        cout << '\n';
    }

    return 0;
}