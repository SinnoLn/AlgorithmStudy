import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      // 1 2 6 24 80 480 0 0 0 00
      
      StringBuilder sb = new StringBuilder();
      int[] cnt = new int[2];
      for(int i=n; i>0; i--){
        //2와 5의 개수
        int num = i;
        while(num%2 == 0){
          cnt[0]++;
          num/=2;
        }
        
        while(num%5==0){
          cnt[1]++;
          num/=5;
        }
      }
      
      int ans = Math.min(cnt[0] , cnt[1]);
      System.out.println(ans);
    }
}