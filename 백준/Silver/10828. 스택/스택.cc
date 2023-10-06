#include <bits/stdc++.h>
using namespace std;
int num, pushnum;
string order;
vector<int> stackM;
// c++에는 스택이 있지만 그냥 vector로 구현해보겠음

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> num;
    for (int i = 0; i < num; i++)
    {
        cin >> order;
        if (order == "push")
        {
            cin >> pushnum;
            stackM.push_back(pushnum);
        }
        else if (order == "pop")
        {
            if (stackM.empty() != 1)
            {
                cout << stackM.back() << endl;
                stackM.pop_back();
            }
            else
                cout << -1 << endl;
        }
        else if (order == "size")
        {
            cout << stackM.size() << endl;
        }
        else if (order == "empty")
        {
            if (stackM.empty())
                cout << 1 << endl;
            else
                cout << 0 << endl;
        }
        else if (order == "top")
        {
            if (stackM.empty() != 1)
                cout << stackM.back() << endl;
            else
                cout << -1 << endl;
        }
    }

    return 0;
}
