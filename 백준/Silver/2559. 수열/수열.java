import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      int[] arr = new int[n+1];
      st = new StringTokenizer(br.readLine());
      for(int i=1; i<n+1; i++) arr[i] = Integer.parseInt(st.nextToken());
      
      int[] prefixSum = new int[n+1];
      for(int i=1; i<=n; i++){
        prefixSum[i] = prefixSum[i-1] + arr[i];
      }
      
      int ans = Integer.MIN_VALUE;
      for(int i=m; i<n+1; i++){
        int tmp = prefixSum[i] - prefixSum[i-m];
        ans = Math.max(tmp, ans);
      }
      
      System.out.println(ans);
    }
}