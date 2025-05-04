import java.util.*;
import java.io.*;

public class Solution {
   static boolean[] dia1;
   static boolean[] dia2;
   static boolean[] col;
   static int ans;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        dia1 = new boolean[2*n];
        dia2 = new boolean[2*n];
        col = new boolean[n];
        ans = 0;
        
        backtrack(0, n);
        
        System.out.println("#"+t+" "+ans);
      }
    }
      
      static void backtrack(int row, int n){
        //마지막 행까지 내려가도 return이 안됐다면
        if(row == n){
          ans++;
          return;
        }
        //행을 내려가면서 퀸을 놓을 수 있는지 탐색
        for(int i=0; i<n; i++){
          if(col[i] || dia1[row+i] || dia2[row-i+(n-1)]) continue;
          col[i] = dia1[row+i] = dia2[row-i+(n-1)] = true;
          backtrack(row+1, n);
          col[i] = dia1[row+i] = dia2[row-i+(n-1)] = false;
        }
      }
}