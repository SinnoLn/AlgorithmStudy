#include <iostream>
using namespace std;

int h, n, w, testCase, room;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> testCase;
    for (int i = 0; i < testCase; i++)
    {
        cin >> h >> w >> n;
        if (n % h != 0)
            room = (100 * (n % h)) + (n / h + 1);
        else
            room = (100 * h) + (n / h);

        cout << room << '\n';
    }

    return 0;
}