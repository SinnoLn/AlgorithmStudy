import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        double sum = 0.0;
        int[] people = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          people[i] = Integer.parseInt(st.nextToken());
          sum+=people[i];
        }
        sum/=n;
        
        int cnt = 0;
        for(int p : people){
          if(sum>=p) cnt++;
        }
        System.out.println("#"+t+" "+cnt);
      }
  }
}