import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int a = Integer.parseInt(st.nextToken())/2;
      int b = Integer.parseInt(st.nextToken());
      
      //빵 2개
      //패티 1개
      
      System.out.println(Math.min(a,b));
    }
}