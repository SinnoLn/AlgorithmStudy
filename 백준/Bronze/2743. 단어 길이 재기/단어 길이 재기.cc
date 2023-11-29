#include <iostream>

using namespace std;

string words;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> words;

    cout << words.size() << '\n';

    return 0;
}