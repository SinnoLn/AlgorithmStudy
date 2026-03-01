import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      Stack<Integer> stack = new Stack<>();
      for(int i=0; i<n; i++){
        String[] input = br.readLine().split(" ");
        
        if(input[0].equals("push")){
          int num = Integer.parseInt(input[1]);
          stack.push(num);
        }
        else if(input[0].equals("pop")){
          if(stack.isEmpty()) System.out.println(-1);
          else{
            int value = stack.pop();
            System.out.println(value);
          }
        }
        else if(input[0].equals("size")){
          System.out.println(stack.size());
        }
        else if(input[0].equals("empty")){
          if(stack.isEmpty()) System.out.println(1);
          else System.out.println(0);
        }
        else if(input[0].equals("top")){
          if(stack.isEmpty()) System.out.println(-1);
          else System.out.println(stack.peek());
        }
        
      }
      
    }
}