#include <iostream>

using namespace std;

string words;
int test;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> test;

    for (int i = 0; i < test; i++)
    {
        cin >> words;
        cout << words.front() << words.back() << '\n';
    }

    return 0;
}