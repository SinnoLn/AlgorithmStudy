import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      BigInteger n = new BigInteger(st.nextToken());
      BigInteger m = new BigInteger(st.nextToken());
      
      BigInteger q = n.divide(m);
      BigInteger r = n.remainder(m);
      
      System.out.println(q);
      System.out.println(r);
  }
}