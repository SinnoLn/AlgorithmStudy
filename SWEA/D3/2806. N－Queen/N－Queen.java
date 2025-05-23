import java.util.*;
import java.io.*;

public class Solution {
    static boolean[] col;
    static boolean[] d1;
    static boolean[] d2;
    static int ans;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        col = new boolean[n];
        d1 = new boolean[n*2];
        d2 = new boolean[n*2];
        ans = 0;
        
        dfs(0, n);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static void dfs(int row, int n){
    if(row == n){
      ans++;
      return;
    }
    
    for(int i=0; i<n; i++){
      if(col[i] || d1[row+i] || d2[row-i+(n-1)]) continue;
      col[i] = d1[row+i] = d2[row-i+(n-1)] = true;
      dfs(row+1, n);
      col[i] = d1[row+i] = d2[row-i+(n-1)] = false;
    }
  }
}