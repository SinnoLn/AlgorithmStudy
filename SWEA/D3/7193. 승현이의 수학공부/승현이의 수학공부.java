import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String x = st.nextToken();
        
        int sum = 0;
        for(int i=0; i<x.length(); i++){
          sum+=x.charAt(i)-'0';
        }
        System.out.println("#"+t+" "+sum%(n-1));
      }
  }
}