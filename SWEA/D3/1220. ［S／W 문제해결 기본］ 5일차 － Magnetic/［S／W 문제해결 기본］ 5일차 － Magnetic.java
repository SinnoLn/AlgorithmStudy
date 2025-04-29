import java.util.*;
import java.io.*;

public class Solution {
    static int[][] table;
    static int n;
    public static void main(String[] args) throws IOException{
      //1은 N극 
      //2는 S극
      //0은 없음
      //테이블 위 N극, 아래 S극
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++){
        n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            table[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        //교착이란? : 1다음에 2가오는 것
        int cnt = 0;
        for(int i=0; i<n; i++){
          boolean check = false;
          for(int j=0; j<n; j++){
            if(table[j][i] == 1) check = true;
            if(table[j][i] == 2){
              if(check == true){
                cnt++;
                check = false;
              }
            }
          }
        }
        System.out.println("#"+t+" "+cnt);
      }
  }
}