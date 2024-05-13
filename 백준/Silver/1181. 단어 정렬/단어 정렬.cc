#include <iostream>
#include <map>
#include <set>
#include <string>

using namespace std;
int n;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    map<int, set<string>> words;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string word;
        cin >> word;
        words[word.size()].insert(word);
    }

    for (auto &length_set_pair : words) {
        for (const auto &word : length_set_pair.second) { 
            cout << word << '\n'; 
        }
    }

    return 0;
}
