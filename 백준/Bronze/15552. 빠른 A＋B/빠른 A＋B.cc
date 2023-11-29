#include <iostream>

using namespace std;

int test, a, b;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> test;

    for (int i = 0; i < test; i++)
    {
        cin >> a >> b;
        cout << a + b << '\n';
    }

    return 0;
}