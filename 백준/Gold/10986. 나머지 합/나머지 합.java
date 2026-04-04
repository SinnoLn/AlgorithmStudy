import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //나누어 떨어지긴 위해선?
      //구간합의 약수가 반드시 M을 포함해야한다.
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(br.readLine());
      int[] arr = new int[n+1];
      for(int i=1; i<n+1; i++) arr[i] = Integer.parseInt(st.nextToken());
      
      long[] prefix = new long[n+1];
      for(int i=1; i<n+1; i++){
        prefix[i] = prefix[i-1] + arr[i];
      }
      
      //나머지 구간 구하기
      long[] cnt = new long[m];
      for(int i=0; i<n+1; i++){
        int result = (int)(prefix[i]%m);
        cnt[result]++;
      }
      
      //조합 계산하기
      long ans = 0L;
      for(int i=0; i<m; i++){
        long num = cnt[i];

        if(num>=2){
          ans+=num*(num-1)/2;
        }
      }
      System.out.println(ans);
    }
}