import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      
      int[] num = new int[n];

      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++){
        num[i] = Integer.parseInt(st.nextToken());
      }
    
    // 연속 부분 수열 1억을 만드는것이 가능한가
    
    int l = 0;
    int r = 0;
    int minLen = Integer.MAX_VALUE;
    int len = 1;
    int currSum = num[l];
    
    while(l<n){
      //더 크거나 같다면
      if(currSum>=s){
        minLen = Math.min(len, minLen);
        currSum-=num[l];
        l++;
        len--;
      }
      else {
        //더 작다면
        r++;
        if(r == n) break;
        currSum+=num[r];
        len++;
      }
    }
    if(minLen == Integer.MAX_VALUE) minLen = 0;
    System.out.println(minLen);
    }
}