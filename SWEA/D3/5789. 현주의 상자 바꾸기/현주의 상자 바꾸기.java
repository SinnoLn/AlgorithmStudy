import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1];
        
        for(int i=1; i<=q; i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          
          for(int j=a; j<=b; j++) num[j]=i;
        }
        System.out.print("#"+t+" ");
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) sb.append(num[i]).append(" ");
        System.out.println(sb.toString());
      }
  }
}