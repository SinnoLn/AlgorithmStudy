import java.util.*;
import java.io.*;

public class Main {
    static char[] word;
    static int l,c;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      l = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      
      word = new char[c];
      
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<c; i++){
        word[i] = st.nextToken().charAt(0);
      }
      
      Arrays.sort(word);
      
      StringBuilder sb = new StringBuilder();
      backtrack(sb, 0, 0);
    }
    
    static void backtrack(StringBuilder sb, int depth, int start){
      if(depth == l) {
        if (isValid(sb.toString())) {
            System.out.println(sb.toString());
        }
        return;
      }
      
      for (int i = start; i < c; i++) { 
        sb.append(word[i]);
        backtrack(sb, depth + 1, i + 1);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
    
    static boolean isValid(String input){
      int m = 0;
      for(int i=0; i<input.length(); i++){
        if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') m++;
      }
      
      if(m>0 && (input.length()-m)>1) return true;
      else return false;
    }
}