import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      
      int[] arr = new int[n];
      
      for(int i=0; i<n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      //슬라이딩 윈도우
      int sum = 0;
      ////////////
      for(int i=0;i<k;i++) sum+=arr[i];
      int ans = sum;
      
      for(int i=0; i<n-k; i++){
        sum = sum - arr[i] + arr[i+k];
        ans = Math.max(ans, sum);
      }
      
      System.out.println(ans);
  }
}