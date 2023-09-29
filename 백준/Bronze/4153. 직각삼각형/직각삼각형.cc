#include <iostream>
#include <algorithm>

using namespace std;

int length[3], sum;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (1)
    {
        cin >> length[0] >> length[1] >> length[2];
        if (length[0] == 0 && length[1] == 0 && length[2] == 0)
            break;

        sort(length, length + 3);

        sum = (length[1] * length[1]) + (length[0] * length[0]);

        if ((length[2] * length[2]) == sum)
            cout << "right" << '\n';
        else
            cout << "wrong" << '\n';
    }

    return 0;
}