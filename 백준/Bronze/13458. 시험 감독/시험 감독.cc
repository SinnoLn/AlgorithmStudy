#include <iostream>
#include <math.h>
using namespace std;

int n, b, c;
long long result;
int ar[1000000];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    result = n;

    for (int i = 0; i < n; i++) // 방의 수
        cin >> ar[i];

    cin >> b >> c;
    for (int j = 0; j < n; j++)
    {
        if ((ar[j] - b) > 0)
        {
            if ((ar[j] - b) > c)
                result += ceil((ar[j] - b) / (double)c);
            else
                result++;
        }
    }

    cout << result << '\n';
    return 0;
}