import java.util.*;
import java.io.*;

public class Solution {
   static class Line{
     int from;
     int to;
     public Line(int from, int to){
       this.from = from;
       this.to = to;
     }
   };
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];
        
        for(int i=0; i<n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine());
          int from = Integer.parseInt(st.nextToken());
          int to = Integer.parseInt(st.nextToken());
          
          lines[i] = new Line(from, to);
        }
        
        int cnt = 0;
        for(int i=0; i<n-1; i++){
          for(int j=i+1; j<n; j++){
            int a1 = lines[i].from;
            int b1 = lines[i].to;
            int a2 = lines[j].from;
            int b2 = lines[j].to;
            
            if((a1<a2 && b1>b2)||(a1>a2 && b1<b2)) cnt++;
          }
        }
        System.out.println("#"+t+" "+cnt);
      }
  }
}