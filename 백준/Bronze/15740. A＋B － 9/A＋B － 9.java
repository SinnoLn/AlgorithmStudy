import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException{
      //10의 만승
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      String a = st.nextToken();
      String b = st.nextToken();
      
      BigInteger ba = new BigInteger(a);  
      BigInteger bb = new BigInteger(b); 
      
      BigInteger result = ba.add(bb);
      System.out.println(result);
  }
}