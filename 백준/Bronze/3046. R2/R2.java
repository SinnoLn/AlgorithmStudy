import java.util.*;
import java.io.*;

public class Main {
    //R1+R2/2 = S
    //R2 = 2S-R1
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int r1 = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      
      System.out.println(2*s-r1);
  }
}