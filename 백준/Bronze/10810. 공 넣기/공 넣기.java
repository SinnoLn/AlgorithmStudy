import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      int[] box = new int[n+1];
      for(int b=0; b<m; b++){
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for(int a=i; a<=j; a++){
          box[a] = k;
        }
      }
      
      StringBuilder sb = new StringBuilder();
      for(int i=1; i<n+1; i++) sb.append(box[i]).append(" ");
      System.out.println(sb.toString());
  }
}