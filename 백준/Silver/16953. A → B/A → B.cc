// A -> B

#include <iostream>
#include <string>

using namespace std;
string a, b;
int ans = 1, num_b;

int main() {

    cin >> a >> b;
    
    while(stoi(b) > stoi(a)){
        num_b = stoi(b);
        if(num_b%2 == 0){
            b = to_string(num_b / 2);
            ans++;
        }
        else {
            if(b.back() == '1'){
                b.pop_back();
                ans++;
            }
            else
                break;
        }
    }

    if(a != b)
        cout << "-1" << '\n';
    else
        cout << ans << '\n';
    
    return 0;
}