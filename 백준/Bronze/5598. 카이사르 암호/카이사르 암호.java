import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input = br.readLine();
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<input.length(); i++){
        int pos = input.charAt(i)-3;
        if(pos<65) pos+=26;

        sb.append((char)pos);
      }
      System.out.println(sb.toString());
  }
}