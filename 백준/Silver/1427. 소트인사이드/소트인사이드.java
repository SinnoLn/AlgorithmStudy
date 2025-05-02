import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      
      char[] cArr = new char[s.length()];
      for(int i=0; i<s.length(); i++) cArr[i] = s.charAt(i);
      Arrays.sort(cArr);
      
      for(int i=s.length()-1; i>-1; i--) System.out.print(cArr[i]);
  }
}