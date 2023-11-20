#include <iostream>
using namespace std;
int a, b, countNum = 2, n = 2, result;
int arr[1001];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> a >> b;

    arr[0] = 0;
    arr[1] = 1;

    while (n != 1001)
    {
        for (int j = 1; j <= countNum; j++)
        {
            if (n == 1001)
                break;
            arr[n] = arr[n - 1] + countNum;
            n++;
        }
        countNum++;
    }

    arr[1000] = arr[999] + (countNum - 1);

    result = arr[b] - arr[a - 1];
    cout << result << '\n';

    return 0;
}