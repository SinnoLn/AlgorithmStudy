import java.util.*;
import java.io.*;

//백트랙킹
public class Main {
    static class Info {
      int time;
      int pay;
      
      public Info(int time, int pay){
        this.time = time;
        this.pay = pay;
      }
    }
    static Info pay[];
    static int n, ans;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      
      // 1<=n<=15
      // 상담을 하거나 안하거나
      // 2^15 -> 7만 정도
      // 최대 수익
      
      pay = new Info[n];
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        pay[i] = new Info(t,p);
      }
      
      backtrack(0,0);
      System.out.println(ans);
    }
    
    static void backtrack(int day, int total){
      
      ans = Math.max(total, ans);
      
      if(day >= n) return;

      backtrack(day+1, total);
      if(day + pay[day].time <= n){
       backtrack(day+pay[day].time, total+pay[day].pay);  
      }
    }
}