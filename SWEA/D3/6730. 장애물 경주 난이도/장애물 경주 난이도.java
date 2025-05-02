import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) stair[i] = Integer.parseInt(st.nextToken());
        
        int maxUp = 0;
        int maxDown = 0;
        
        for(int i=0; i<n-1; i++){
          int diff = stair[i+1] - stair[i];
          
          if (diff > 0) maxUp = Math.max(maxUp, diff);
          else if (diff < 0) maxDown = Math.max(maxDown, -diff);
        }
        System.out.println("#"+t+" "+ maxUp +" "+maxDown);
      }
  }
}