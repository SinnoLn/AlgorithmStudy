import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      while(true){
        String input = br.readLine();
        if(input.equals(".")) break;
        
        if(check(input)) System.out.println("yes");
        else System.out.println("no");
      }
  }
  static boolean check(String input){
    Stack<Character> stack = new Stack<>();
        for(int i=0; i<input.length(); i++){
          char c = input.charAt(i);

          if(c == '(' || c == '[') stack.add(c);
          if(c == ')' || c == ']'){
            if(stack.isEmpty()) return false;
            if(stack.peek() == '(' && c != ')') return false;
            if(stack.peek() == '[' && c != ']') return false;
            stack.pop();
          }
        }
        if(!stack.isEmpty()) return false;
        return true;
  }
}