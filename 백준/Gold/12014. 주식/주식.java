import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    static int[] stock;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //n일간의 주식 가격, n개의 숫자.
      //K번 주식을 사기
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        stock = new int[n];
        for(int i=0; i<n; i++) stock[i] = Integer.parseInt(st.nextToken());
        System.out.println("Case"+" #"+t);
        if(isPossible()) System.out.println(1);
        else System.out.println(0);
      }
  }
  
  static boolean isPossible() {
    int[] dp = new int[n];
    for(int i=0; i<n; i++) dp[i] = 1;
    
    int ans = 1;
    for(int i=0; i<n-1; i++){
      for(int j=i+1; j<n; j++){
        if(stock[i] < stock[j]){
          dp[j] = Math.max(dp[j], dp[i]+1);
          ans = Math.max(ans, dp[j]);
        }
      }
    }
    if(ans >= k) return true;
    return false;
  }
}