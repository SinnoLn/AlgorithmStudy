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
      for(int i=1; i<n+1; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      //2<=나머지<=1000
      long[] prefixSum = new long[n+1];
      for(int i=1; i<n+1; i++){
        prefixSum[i] = prefixSum[i-1] + arr[i];
      }
      
      long[] cnt = new long[m];
      for(int i=0; i<=n; i++){
        int r = (int)(prefixSum[i]%m);
        cnt[r]++;
      }
      
      //조합 생성하기
      long result = 0;
      for(int r=0; r<m; r++){
        long c = cnt[r];
        if(c>=2){
          result += c*(c-1)/2;
        }
      }
      
      System.out.println(result);
  }
}