import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      int[] alphabet = new int[26];
      
      for(int i=0; i<n; i++) {
        char input = br.readLine().charAt(0);
        alphabet[input-'a']++;
      }
      
      StringBuilder sb = new StringBuilder();
      
      for(int i=0; i<26; i++){
        if(alphabet[i]>4){
          sb.append((char)(i+'a'));
        }
      }
      
      if(sb.length()==0) System.out.println("PREDAJA");
      else System.out.println(sb.toString());
  }
}