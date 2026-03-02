import java.util.*;
import java.io.*;

public class Main {
    static int[] order;
    static List<Character> ans = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      n = Integer.parseInt(br.readLine());
      order = new int[n];

      for(int i=0; i<n; i++){
        order[i] = Integer.parseInt(br.readLine());
      }
      
      boolean check = solveOrder();
      
      if(check){
        for(char c : ans){
          bw.write(c);
          bw.write('\n');
        }
      }
      else System.out.println("NO");
      
      bw.flush();
      bw.close();
      br.close();
    }
    
    static boolean solveOrder(){
      Stack<Integer> stack = new Stack<>();
      int idx = 0;
      int data = 1;
      while(idx != n){
          while(data <= order[idx]) {
            
            if(!stack.isEmpty() && stack.peek() == order[idx]){
              ans.add('-');
              stack.pop();
              idx++;
              break;
            }
            stack.add(data);
            data++;
            ans.add('+');
          }
          
          while(data > order[idx]){
            if(!stack.isEmpty() && stack.peek() == order[idx]){
              ans.add('-');
              stack.pop();
              idx++;
              break;
            }
            ans.add('-');
            if(stack.isEmpty()) return false;
            else stack.pop();
          }
      }
      return true;
    }
}