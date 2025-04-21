import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      
      for(int test = 1; test<=t; test++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); //총 영역 크기
        int m = Integer.parseInt(st.nextToken()); //탐지할 공간 크기
        
        int[][] area = new int[n][n];
        
        for(int i=0; i<n; i++){
          st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            area[i][j] = Integer.parseInt(st.nextToken());
          }
        }
          
          int ans = 0;
          for(int i=0; i<n-m+1; i++){
            for(int j=0; j<n-m+1; j++){
              int sum = 0;
              for(int y = i; y<i+m; y++){
                for(int x = j; x<j+m; x++){
                  sum+=area[y][x];
                }
              }
              ans = Math.max(ans, sum);
            }
          }
           System.out.println("#"+test+" "+ans);
        }
      }
    }