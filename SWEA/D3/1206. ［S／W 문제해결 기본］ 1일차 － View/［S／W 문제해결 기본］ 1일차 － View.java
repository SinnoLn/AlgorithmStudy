import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int t=1; t<=10; t++){
        int n = Integer.parseInt(br.readLine());
        int[] building = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) building[i] = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        for(int i=2; i<n-2; i++){
          int left = Math.max(building[i-1], building[i-2]);
          int right = Math.max(building[i+1], building[i+2]);
          int sum = Math.max(left,right);
          
          int view = building[i] - sum;
          if(view<0) view = 0;
          
          cnt+=view;
        }
        
        System.out.println("#"+t+" "+cnt);
      }
  }
}