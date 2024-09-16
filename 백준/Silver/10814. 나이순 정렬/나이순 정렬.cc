#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<pair<int, string>> members(n);

    for (int i = 0; i < n; i++) {
        int age;
        string name;
        cin >> age >> name;
        members[i] = {age, name};
    }

    stable_sort(members.begin(), members.end(), [](const pair<int, string>& a, const pair<int, string>& b) {
        return a.first < b.first;
    });

    for (int i = 0; i < n; i++) {
        cout << members[i].first << " " << members[i].second << '\n';
    }

    return 0;
}
