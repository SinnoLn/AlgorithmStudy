#include<iostream>
#include<stack>
#include<vector>
using namespace std;
int n;
stack<int> s;
vector<char> result; 
int current = 1; 
bool possible = true;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;

        while (current <= num) {
            s.push(current);
            result.push_back('+');
            current++;
        }
        
        if (s.top() == num) {
            s.pop();
            result.push_back('-');
        } else {
            possible = false;
            break;
        }
    }

    if (possible) {
        for (char op : result) {
            cout << op << '\n';
        }
    } else {
        cout << "NO" << '\n';
    }

    return 0;
}