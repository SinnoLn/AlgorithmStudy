import java.util.*;
import java.io.*;

public class Main {
    static boolean[] col;
    static boolean[] d1;
    static boolean[] d2;
    static int count = 0;
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      col = new boolean[n];
      d1 = new boolean[2*n];
      d2 = new boolean[2*n];
      dfs(0, n);
      
      System.out.println(count);
  }
  
  static void dfs(int row, int n){
    if(row == n) {
      count++;
      return;
    }
    
    for(int c=0; c<n; c++){
      if(col[c]|| d1[row+c] || d2[row-c+n-1]) continue;
      
      col[c] = d1[row+c] = d2[row-c+n-1] = true;
      dfs(row+1, n);
      col[c] = d1[row+c] = d2[row-c+n-1] = false;
    }
  }
}