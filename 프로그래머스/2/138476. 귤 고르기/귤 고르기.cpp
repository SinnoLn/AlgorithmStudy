#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int dic[10000001];
int sum;
int solution(int k, vector<int> tangerine) {
    int answer = 0;
    for(int i=0; i<tangerine.size(); i++){
        dic[tangerine[i]]++;
    }
    sort(dic, dic+10000001, greater<int>{});
    for(int i=0; i<10000001; i++){
        if(sum >= k) break;
        sum+=dic[i];
        answer++;
    }
    return answer;
}