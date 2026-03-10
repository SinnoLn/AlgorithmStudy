import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //좋은 단어
      int n = Integer.parseInt(br.readLine());
      int ans = 0;
      
      for(int i=0; i<n; i++){
        String input = br.readLine();
        boolean check = isGoodWord(input);
        
        if(check) ans++; 
      }
      
      System.out.println(ans);
    }
    
    static boolean isGoodWord(String input){
      if(input.length()%2 !=0) return false;
      
      Stack<Character> stack = new Stack<>();
      
      for(int i=0; i<input.length(); i++){
        char c = input.charAt(i);
        
        if(!stack.isEmpty() && stack.peek() == c){
          stack.pop();
        }
        else stack.push(c);
      }
      
      if(!stack.isEmpty()) return false;
      return true;
    }
}