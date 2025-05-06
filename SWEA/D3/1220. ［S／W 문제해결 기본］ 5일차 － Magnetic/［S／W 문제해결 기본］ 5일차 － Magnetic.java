import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int[][] magnetic;;
      for(int t=1; t<=10; t++){
        int n = Integer.parseInt(br.readLine());
        magnetic = new int[n][n];
        
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          for(int j=0; j<n; j++){
            magnetic[i][j] = Integer.parseInt(st.nextToken());
          }
        }
        
        //1 n극
        //2 s극
        int ans = 0;
        for(int i=0; i<n; i++){
          boolean check = false;
          for(int j=0; j<n; j++){
            if(magnetic[j][i] == 1) check = true;
            if(magnetic[j][i] == 2 && check){
              ans++;
              check = false;
            }
          }
        }
        
        System.out.println("#"+t+" "+ans);
      }
  }
}