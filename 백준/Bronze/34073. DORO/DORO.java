import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<n; i++){
        String s = st.nextToken();
        sb.append(s).append("DORO").append(" ");
      }
      System.out.println(sb.toString());
    }
}