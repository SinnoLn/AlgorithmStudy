#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;
vector<int> arr;
int n, num, r, l, sum = -2100000000, tmp;
int ll, rr;
int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> num;
        arr.push_back(num);
    }

    // sort?
    sort(arr.begin(), arr.end());

    // 정렬후 r,l
    l = 0;
    r = arr.size() - 1;

    while (l != r)
    {
        tmp = arr[l] + arr[r];
        // tmp가 절댓값이 더 작을 경우
        if (abs(sum) > abs(tmp))
        {
            sum = tmp;
            ll = arr[l];
            rr = arr[r];
        }

        // 음수면 left ++
        if (tmp < 0)
            l++;
        // 양수면 right ++
        else if (tmp > 0)
            r--;
        else
            break;
    }

    std::cout << ll << " " << rr << '\n';
    return 0;
}