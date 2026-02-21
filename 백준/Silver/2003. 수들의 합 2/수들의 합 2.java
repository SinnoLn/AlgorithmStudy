import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //특정 구간의 숫자 합이 m이 되는 경우의 수
      //전형적인 투포인터 문제
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      int[] arr = new int[n];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      int l = 0;
      int r = 0;
      int cnt = 0;
      
      int sum = arr[0];
      while(true){
        if(l == (n-1) && r == (n-1)){
          if(arr[n-1] == m) cnt++;
          break;
        }
        
        if(sum == m) cnt++;
        
        if(sum<m) {
          if(r+1>n-1)break;
          r++;
          sum+=arr[r];
        }
        else if(sum>=m) {
          sum-=arr[l];
          l++;
        }
      }
      
      System.out.println(cnt);
    }
}