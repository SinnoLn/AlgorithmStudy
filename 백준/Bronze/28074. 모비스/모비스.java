import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input = br.readLine();
      
      if(findMOBOIS(input)) System.out.println("YES");
      else System.out.println("NO");
    }
    
    static boolean findMOBOIS(String input){
      if(input.length() < 5) return false;
      
      int[] word = new int[26];
      for(int i=0; i<input.length(); i++){
        char c = input.charAt(i);
        word[c-'A']++;
      }
      
      if(word['M'-'A'] == 0 || word['O'-'A'] == 0 | word['B'-'A'] == 0 | word['I'-'A'] == 0 | word['S'-'A'] == 0 ) return false;
      return true;
    }
}