import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] snacks = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) snacks[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(snacks);
        
        int left = 0;
        int right = n-1;
        
        int ans = -1;
        while(left<right){
          int sum = snacks[left] + snacks[right];
          if(sum == m){
            ans = m;
            break;
          } 
          else if(sum > m) right--;
          else {
            ans = Math.max(ans, sum);
            left++;
          }
        }
        System.out.println("#"+t+" "+ans);
      }
  }
}