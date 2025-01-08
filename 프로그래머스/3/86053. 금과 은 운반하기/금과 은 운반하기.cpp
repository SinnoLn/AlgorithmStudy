#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

long long solution(int a, int b, vector<int> g, vector<int> s, vector<int> w, vector<int> t) {
    
    long long max_time = 0;
    for (int i = 0; i < g.size(); i++) {
        long long total_weight = (long long)(a + b);
        long long trips = (total_weight + w[i] - 1) / w[i];
        long long city_time = (trips - 1) * 2 * t[i] + t[i];
        max_time = max(max_time, city_time);
    }
    
    long long answer = -1;
    //시간 기준 
    long long left = 0; 
    long long right = max_time;
    
    //이진탐색
    while(left <= right){
        long long mid = (left+right)/2;
        
        long long total_g = 0;
        long long total_s = 0;
        long long total_gs = 0;
        
        for(int i=0; i<g.size(); i++){
            long long trips = mid / (2*t[i]);
            if (mid % (2 * t[i]) >= t[i]) trips++;
            
            // cout << "trips: " << trips <<'\n';
            
            long long max_transport = trips*w[i];
            total_g += min((long long)g[i], max_transport);
            total_s += min((long long)s[i], max_transport);
            total_gs += min((long long)g[i]+s[i], max_transport);
            
             // cout << "total_g: " << total_g <<'\n';
             // cout << "total_s: " << total_s <<'\n';
             // cout << "total_gs: " << total_gs <<'\n';
        }
        
        if(total_g >= a && total_s >= b && total_gs >= (a+b)){
            answer = mid;
            right = mid - 1;
        } 
        else {
            left = mid + 1;
        }
    }
    return answer;
}