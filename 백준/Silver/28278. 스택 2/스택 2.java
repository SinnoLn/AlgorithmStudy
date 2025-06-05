import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      Stack<Integer> stack = new Stack<>();
      
      int n = Integer.parseInt(br.readLine());
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int op = Integer.parseInt(st.nextToken());
        
        if(op == 1){
          int num = Integer.parseInt(st.nextToken());
          stack.push(num);
        }
        else if(op == 2){
          if(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
          }
          else System.out.println(-1);
        }
        else if(op == 3){
          System.out.println(stack.size());
        }
        else if(op == 4){
          if(stack.isEmpty()) System.out.println(1);
          else System.out.println(0);
        }
        else{
          if(!stack.isEmpty()){
            System.out.println(stack.peek());
          }
          else System.out.println(-1);
        }
      }
  }
}