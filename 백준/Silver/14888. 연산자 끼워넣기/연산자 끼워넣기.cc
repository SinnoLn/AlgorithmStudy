#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, maxResult = -1e9, minResult = 1e9; // 결과의 최댓값, 최솟값 초기화
vector<int> numbers; // 입력받을 수
int oper[4]; // 연산자 개수 (덧셈, 뺄셈, 곱셈, 나눗셈)

// 백트래킹으로 가능한 모든 연산자 조합을 계산
void dfs(int idx, int current) {
    if (idx == n) { // 모든 수를 다 처리한 경우
        maxResult = max(maxResult, current); // 최대값 갱신
        minResult = min(minResult, current); // 최솟값 갱신
        return;
    }

    // 각 연산자를 사용할 수 있는지 확인 후 연산 수행
    for (int i = 0; i < 4; i++) {
        if (oper[i] > 0) { // 해당 연산자를 사용할 수 있는 경우
            oper[i]--; // 연산자 사용

            if (i == 0) { // 덧셈
                dfs(idx + 1, current + numbers[idx]);
            }
            else if (i == 1) { // 뺄셈
                dfs(idx + 1, current - numbers[idx]);
            }
            else if (i == 2) { // 곱셈
                dfs(idx + 1, current * numbers[idx]);
            }
            else if (i == 3) { // 나눗셈
                // 음수일 때 나눗셈 처리
                if (current < 0) {
                    dfs(idx + 1, -(-current / numbers[idx]));
                } else {
                    dfs(idx + 1, current / numbers[idx]);
                }
            }
            oper[i]++; // 연산자 복구
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    numbers.resize(n);

    for (int i = 0; i < n; i++) {
        cin >> numbers[i];
    }

    for (int i = 0; i < 4; i++) {
        cin >> oper[i];
    }

    // 백트래킹 시작 
    dfs(1, numbers[0]);

    // 결과 출력
    cout << maxResult << '\n';
    cout << minResult << '\n';

    return 0;
}