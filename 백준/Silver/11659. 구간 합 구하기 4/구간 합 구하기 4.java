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
      for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
      
      long[] prefixSum = new long[n+1];
      for(int i=1; i<=n; i++){
        prefixSum[i] = prefixSum[i-1] + arr[i];
      }
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        sb.append(prefixSum[b] - prefixSum[a-1]).append('\n');
      }
      
      System.out.println(sb);
    }
}