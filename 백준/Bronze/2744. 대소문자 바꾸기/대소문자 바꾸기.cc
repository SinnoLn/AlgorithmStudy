#include <iostream>

using namespace std;

string word, result;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> word;

    for (char s : word)
    {
        if (s >= 'a' && s <= 'z')
            result += s - 32;
        else if (s >= 'A' && s <= 'Z')
            result += s + 32;
    }

    cout << result << '\n';

    return 0;
}