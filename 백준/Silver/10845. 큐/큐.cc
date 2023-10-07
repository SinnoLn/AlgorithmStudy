#include <bits/stdc++.h>
using namespace std;
vector<int> queues;
string order;
int n, num;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cin >> order;
        if (order == "push")
        {
            cin >> num;
            queues.push_back(num);
        }
        else if (order == "pop")
        {
            if (queues.empty() != 1)
            {
                cout << queues.front() << endl;
                queues.erase(queues.begin());
            }
            else
                cout << -1 << endl;
        }
        else if (order == "size")
        {
            cout << queues.size() << endl;
        }
        else if (order == "empty")
        {
            if (queues.empty() == 1)
                cout << 1 << endl;
            else
                cout << 0 << endl;
        }
        else if (order == "front")
        {
            if (queues.empty() != 1)
                cout << queues.front() << endl;
            else
                cout << -1 << endl;
        }
        else if (order == "back")
        {
            if (queues.empty() != 1)
                cout << queues.back() << endl;
            else
                cout << -1 << endl;
        }
    }

    return 0;
}
