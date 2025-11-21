import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      
      int[] arr = new int[n+1];
      for(int i=1; i<n+1; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      int[] prefixSum = new int[n+1];
      for(int i=1; i<n+1; i++){
        prefixSum[i] = prefixSum[i-1] + arr[i];
      }
      
      int result = Integer.MIN_VALUE;
      for(int i=k; i<n+1; i++){
        int sum = prefixSum[i] - prefixSum[i-k];
        result = Math.max(result,sum);
      }
      System.out.println(result);
  }
}