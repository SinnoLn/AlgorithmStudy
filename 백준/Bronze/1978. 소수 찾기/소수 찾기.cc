#include <bits/stdc++.h>
using namespace std;

int prime_num;
int num;
int countNum;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> num;
    for (int i = 0; i < num; i++)
    {
        cin >> prime_num;
        if (prime_num == 1)
            countNum++;

        for (int j = 2; j < prime_num; j++)
        {
            if (prime_num % j == 0)
            {
                countNum++;
                break;
            }
        }
    }

    cout << num - countNum << "\n";

    return 0;
}