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
        
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
          st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            arr[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        //이제 시작
        //완전탐색
        //연속성 판단 
        
        //행 탐색
        //1이 가능
        //0이 불가능
        int count = 0;
        int cnt = 0;
        for(int i=0; i<n ;i++){
          cnt = 1;
          for(int j=1; j<n; j++){
            if(arr[i][j] == 0){
              if(cnt == k) count++;
              cnt = 1;
            }
            else if(arr[i][j-1] == arr[i][j]) cnt++;
            else cnt = 1;
          }
          if(cnt == k) count++;
        }
        //열 탐색
        for(int i=0; i<n ;i++){
          cnt = 1;
          for(int j=1; j<n; j++){
            if(arr[j][i] == 0){
              if(cnt == k) count++;
              cnt = 1;
            }
            else if(arr[j-1][i] == arr[j][i]) cnt++;
            else cnt =1;
          }
          if(cnt == k) count++;
        }
        System.out.println("#"+t+" "+count);
      }
  }
}