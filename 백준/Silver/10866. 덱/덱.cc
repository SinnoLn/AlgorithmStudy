#include <bits/stdc++.h>
using namespace std;
vector<int> deck;
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
        if (order == "push_front")
        {
            cin >> num;
            deck.insert(deck.begin(), num);
        }
        else if (order == "push_back")
        {
            cin >> num;
            deck.push_back(num);
        }
        else if (order == "pop_front")
        {
            if (deck.empty() != 1)
            {
                cout << deck.front() << endl;
                deck.erase(deck.begin());
            }
            else
                cout << -1 << endl;
        }
        else if (order == "pop_back")
        {
            if (deck.empty() != 1)
            {
                cout << deck.back() << endl;
                deck.pop_back();
            }
            else
                cout << -1 << endl;
        }
        else if (order == "size")
        {
            cout << deck.size() << endl;
        }
        else if (order == "empty")
        {
            if (deck.empty() == 1)
                cout << 1 << endl;
            else
                cout << 0 << endl;
        }
        else if (order == "front")
        {
            if (deck.empty() != 1)
                cout << deck.front() << endl;
            else
                cout << -1 << endl;
        }
        else if (order == "back")
        {
            if (deck.empty() != 1)
                cout << deck.back() << endl;
            else
                cout << -1 << endl;
        }
    }

    return 0;
}
