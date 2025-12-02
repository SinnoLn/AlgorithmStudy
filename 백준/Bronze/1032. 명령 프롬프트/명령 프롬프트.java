import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      char[] original = br.readLine().toCharArray();
      for(int i=1; i<n; i++){
        String input = br.readLine();
        for(int j=0; j<input.length(); j++){
          if(original[j] == '?') continue;
          if(input.charAt(j) != original[j]) original[j] = '?';
        }
      }
      System.out.println(String.valueOf(original));
    }
}