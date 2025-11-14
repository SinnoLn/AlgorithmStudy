import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      int[] word = new int[26];
      
      for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        word[c-'a']++;
      }
      
      for(int i=0; i<26; i++) System.out.print(word[i]+" ");
  }
}