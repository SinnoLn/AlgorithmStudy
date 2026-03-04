import java.util.*;
import java.io.*;

//원형 큐
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int s = Integer.parseInt(st.nextToken())/2;
      int a = Integer.parseInt(st.nextToken())/2;
      
      int ans = Math.min(s,a);
      System.out.println(ans);
    }
}