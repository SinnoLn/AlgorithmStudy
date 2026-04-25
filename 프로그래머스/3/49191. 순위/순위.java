import java.io.*;
import java.util.*;

//각 노드마다 진 사람 기록
//단방향
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] win = new boolean[n+1][n+1];
        for (int[] res : results) {
            win[res[0]][res[1]] = true;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n ;i++){
                for(int j=1; j<=n; j++){
                    if(win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                if(win[i][j] || win[j][i]) {
                    cnt++;
                }
            }
            if(cnt == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}