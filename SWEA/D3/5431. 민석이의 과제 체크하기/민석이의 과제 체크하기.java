import java.util.*;
import java.io.*;

public class Solution {
    static boolean[] num;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        num = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
          int tmp = Integer.parseInt(st.nextToken());
          num[tmp] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
          if(!num[i]) sb.append(i).append(" ");
        }
        System.out.println("#" + t+" "+sb.toString());
      }
  }
}