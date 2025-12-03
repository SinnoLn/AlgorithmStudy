import java.util.*;
import java.io.*;

//백트랙킹 or DP
public class Main {
    static class Info{
      int day;
      int pay;
      
      public Info(int day, int pay){
        this.day = day;
        this.pay = pay;
      }
    }
    
    static Info[] info;
    static int n, ans;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      info = new Info[n];
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        info[i] = new Info(d,p);
      }
      
      backtrack(0,0);
      System.out.println(ans);
  }
  
  static void backtrack(int idx, int paySum) {
    if(idx >= n){
      ans = Math.max(ans, paySum);
      return;
    }
    
    if(idx+info[idx].day <= n){
      backtrack(idx+info[idx].day, paySum+info[idx].pay);
    }
    
    backtrack(idx+1, paySum);
  }
}