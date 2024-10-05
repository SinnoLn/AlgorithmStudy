#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
vector<pair<int,int>> chicken, home; 
int n, m, a[54][54], result = 987654321;
vector<int> selected;

int calculate_city_distance(){
    int city_distance = 0;

    for(const auto& h : home){
        int min_distance = 987654321;
        for(int idx : selected) {
            int distance = abs(h.first - chicken[idx].first) + abs(h.second - chicken[idx].second); //각 집과 치킨집 사이의 최소 거리 구하기 
            min_distance = min(min_distance, distance); //가장 가까운 치킨집 저장
        }
        city_distance += min_distance;
    }
    return city_distance;
}

void select_chicken(int idx, int cnt){
    if(cnt == m){
        result = min(result, calculate_city_distance());
        return;
    }
    for(int i=idx; i<chicken.size(); i++){
        selected.push_back(i);
        select_chicken(i+1, cnt + 1);
        selected.pop_back();
    }
}

//만약 브루트포스로 풀 생각이면 왜 그렇게 풀어도 되는건지 시간복잡도도 계산 해야만 한다.
int main() {
    
    cin >> n >> m;
    for(int i=0; i<n; i++)
        for(int j=0; j<n; j++){
            cin >> a[i][j];
            if(a[i][j] == 1) //1이면 집 
                home.push_back({i,j}); //집 좌표 저장
            else if(a[i][j] == 2) //2면 치킨집
                chicken.push_back({i,j}); //치킨집 좌표 저장
        }

    select_chicken(0,0);

    cout << result << '\n';
    
    

    //저장한 최소값에서 조합을 이용해 다시 최소값을 찾는데 

    return 0;
}