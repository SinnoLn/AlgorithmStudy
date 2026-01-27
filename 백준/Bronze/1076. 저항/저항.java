import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String a = br.readLine();
      String b = br.readLine();
      String c = br.readLine();
      
      Map<String, Integer> digit = new HashMap<>();
      digit.put("black", 0);
      digit.put("brown", 1);
      digit.put("red", 2);
      digit.put("orange", 3);
      digit.put("yellow", 4);
      digit.put("green", 5);
      digit.put("blue", 6);
      digit.put("violet", 7);
      digit.put("grey", 8);
      digit.put("white", 9);
      
      StringBuilder sb = new StringBuilder();
      sb.append(digit.get(a));
      sb.append(digit.get(b));
      
      int len = digit.get(c);
      for(int i=0; i<len; i++) sb.append("0");
      
      int pos = -1;
      for(int i=0; i<sb.toString().length(); i++){
        if(sb.toString().charAt(i) != '0'){
          pos = i;
          break;
        } 
      }
      
      if(pos == -1) {
        System.out.println("0");
        return;
      }
      String ans = sb.toString().substring(pos, sb.toString().length());
      System.out.println(ans);
  }
}