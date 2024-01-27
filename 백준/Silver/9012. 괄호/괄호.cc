#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;

    while (t--)
    {
        string s;
        cin >> s;

        stack<char> st;
        string answer = "YES";

        for (char ch : s)
        {
            if (ch == '(')
            {
                st.push(ch);
            }
            else
            {
                if (st.empty())
                {
                    answer = "NO";
                    break;
                }
                st.pop();
            }
        }

        if (!st.empty())
        {
            answer = "NO";
        }

        cout << answer << '\n';
    }

    return 0;
}