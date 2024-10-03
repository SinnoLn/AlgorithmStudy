#include <iostream>
#include <vector>

using namespace std;

int stage = 1, du[201],n,k,idx,start,finish,cnt,count_; //최대 컨베이어 벨트 길이 200
bool robot[201]; //기본값 false;

void rotate_belt();
void move_robot();
void put_robot();

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> k;
    //위의 컨베이너 벨트 설정
    start = 1;
    finish = n;
    for(int i=1; i<(2*n+1); i++){
        cin >> du[i]; //컨베이너 내구도
    }

    //단계별 진행
    while(true){
        rotate_belt();
        move_robot();
        put_robot();
        if(count_ >= k)
            break;
        stage ++;
    }

    cout << stage << '\n';

    return 0;
}

//벨트가 칸 위에 있는 로봇과 함께 한 칸 회전
void rotate_belt(){ //총 레일의 길이는 안벗어나도록
    start = (start + 2*n - 1) % (2*n);
    if (start == 0) start = 2*n;
    finish = (finish + 2*n - 1) % (2*n);
    if (finish == 0) finish = 2*n;

    if(robot[finish]) //돌렸는데 로봇이 끝까지 가면
        robot[finish] = false; //내려줌
}

// 로봇을 이동시키는 함수
void move_robot(){
    if(start < finish){ // 순서가 정상일 경우
        for(int i = finish - 1; i >= start; i--){
            if(robot[i]){ // 로봇이 있을 경우
                int next = (i % (2 * n)) + 1;
                if(!robot[next] && du[next] >= 1){
                    robot[i] = false;
                    if(next != finish) { // 이동한 위치가 내리는 위치가 아니면 로봇을 이동
                        robot[next] = true;
                    }
                    du[next]--; // 내구도 감소
                    if(du[next] == 0) count_++; // 내구도가 0이 되면 카운트 증가
                }
            }
        }
        if(robot[finish]) // 내리는 위치에 로봇이 있으면 내림
            robot[finish] = false;
    }
    else if(start > finish) { // start 숫자가 더 큰 경우
        // 벨트의 시작부터 finish-1까지 역순으로 처리
        for(int i = finish - 1; i >= 1; i--){
            if(robot[i]){
                int next = i + 1;
                if(!robot[next] && du[next] >= 1){
                    robot[i] = false;
                    if(next != finish){
                        robot[next] = true;
                    }
                    du[next]--;
                    if(du[next] == 0) count_++; // 내구도가 0이 되면 카운트 증가
                }
            }
        }
        // 벨트의 끝부터 start까지 역순으로 처리
        for(int i = 2 * n; i >= start; i--){
            if(robot[i]){
                int next = (i % (2 * n)) + 1;
                if(next > 2 * n) next = 1; // 벨트가 순환하므로 인덱스 조정
                if(!robot[next] && du[next] >= 1){
                    robot[i] = false;
                    if(next != finish){
                        robot[next] = true;
                    }
                    du[next]--;
                    if(du[next] == 0) count_++; // 내구도가 0이 되면 카운트 증가
                }
            }
        }
        if(robot[finish]) // 내리는 위치에 로봇이 있으면 내림
            robot[finish] = false;
    }
}
//올리는 위치에 칸에 내구도가 0이 아니고 로봇이 없다면 올리는 위치에 로봇 올림
void put_robot(){
    if(du[start] != 0 && !robot[start]){
        robot[start] = true; //올리고
        du[start]--; //내구도 줄이고
        if(du[start] == 0) count_++; // 내구도가 0이 되면 카운트 증가
    }
}