import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] puzzle = new int[n][n];
        for(int i=0; i<n; i++){
          st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            puzzle[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        int ans = findPosition(puzzle, k);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int findPosition(int[][] puzzle, int k){
    int n = puzzle.length;
    int ans = 0;
    
    //열 탐색
    for(int i=0; i<n; i++){
      int cnt = 1;
      for(int j=1; j<n; j++){
        if(puzzle[i][j] == 0){
          if(cnt == k) ans++;
          cnt = 1;
        }
        else if(puzzle[i][j] == puzzle[i][j-1]) cnt++;
      }
      if(cnt == k) ans++;
    }
    //행 탐색
    for(int i=0; i<n; i++){
      int cnt = 1;
      for(int j=1; j<n; j++){
        if(puzzle[j][i] == 0){
          if(cnt == k) ans++;
          cnt = 1;
        }
        else if(puzzle[j][i] == puzzle[j-1][i]) cnt++;
      }
      if(cnt == k) ans++;
    }
    return ans;
  }
}