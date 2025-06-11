import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //B진법을 10진법으로
      StringTokenizer st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      int n = Integer.parseInt(st.nextToken());
      long ans = Long.parseLong(s,n);

      System.out.println(ans);
  }
}