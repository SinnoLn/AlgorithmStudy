import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        int maxUp = 0;
        int maxDown = 0;
        
        int[] stair = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) stair[i] = Integer.parseInt(st.nextToken());
        
        if(n == 2) {
          int diff = stair[0] - stair[1];
          if(diff > 0) maxDown = Math.max(maxDown, diff);
          else if(diff < 0) maxUp = Math.max(maxUp, -diff);
        }
        else{
          for(int i=1; i<n-1; i++){
          int diff1 = stair[i-1] - stair[i]; 
          int diff2 = stair[i] - stair[i+1];
          //내려가면 +
          //올라가면 -
          if(diff1 > 0) maxDown = Math.max(maxDown, diff1);
          else if(diff1 < 0) maxUp = Math.max(maxUp, -diff1);
          
          if(diff2 > 0) maxDown = Math.max(maxDown, diff2);
          else if(diff2 < 0) maxUp = Math.max(maxUp, -diff2);
        }
        }
        System.out.println("#"+t+" "+ maxUp +" "+maxDown);
      }
  }
}