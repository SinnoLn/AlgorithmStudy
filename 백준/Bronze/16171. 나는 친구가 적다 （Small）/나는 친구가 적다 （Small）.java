import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String original = br.readLine();
      String keyword = br.readLine();
      StringBuilder sb = new StringBuilder();
      
      for(int i=0; i<original.length(); i++){
        if(original.charAt(i)>='a' && original.charAt(i)<='z') sb.append(original.charAt(i));
        else if(original.charAt(i)>='A' && original.charAt(i)<='Z') sb.append(original.charAt(i));
      }
      
      if(sb.toString().contains(keyword)) System.out.println(1);
      else System.out.println(0);
  }
}