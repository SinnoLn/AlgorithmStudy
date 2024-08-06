#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    map<string, int> de;
    vector<string> result;
    string name;

    for(int i = 0; i < n; i++) {
        cin >> name;
        de[name] = i;
    }

    for(int j = 0; j < m; j++) {
        cin >> name;
        if(de.find(name) != de.end()) {
            result.push_back(name);
        }
    }

    sort(result.begin(), result.end());

    cout << result.size() << '\n';
    for(const auto& result_name : result) {
        cout << result_name << '\n';
    }

    return 0;
}