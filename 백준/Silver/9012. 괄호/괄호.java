import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      for(int i=0; i<n; i++){
        String s = br.readLine();
        if(idVPS(s)) System.out.println("YES");
        else System.out.println("NO");
      }
    }
    
    static boolean idVPS(String data){
      Stack<Integer>stack = new Stack<>();
      for(int i=0; i<data.length(); i++){
        char c = data.charAt(i);
        if(c == '(') stack.push(1);
        else{
          if(stack.isEmpty()) return false;
          stack.pop();
        }
      }
      if(!stack.isEmpty()) return false;
      else return true;
    }
}