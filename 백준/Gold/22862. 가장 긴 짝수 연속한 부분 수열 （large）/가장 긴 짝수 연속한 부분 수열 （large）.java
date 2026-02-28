import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      int[] arr = new int[n];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
      }
      
      //로직 시작
      //짝수로 이루어진 최장 연속 수열
      //무조건 연속으로 홀수 지우기
      
      int l = 0;
      int r = 0;
      int oddCnt = 0;
      int currLen = 0;
      int maxLen = 0;
      
      if(arr[l]%2 == 1) oddCnt++;
      else {
        currLen = 1;
        maxLen = 1;
      }
      
      
      
      while(l<=r) {
        if(oddCnt>k){
          if(arr[l]%2==1){
            oddCnt--;
          }
          else{
            currLen--;
          }
          l++;
        }
        else {
          r++;
          if(r == n) break;
          
          if(arr[r]%2 == 1){
            oddCnt++;
          }
          else {
            currLen++;
            maxLen = Math.max(maxLen, currLen);
          }
        }
      }
      System.out.println(maxLen);
    }
}