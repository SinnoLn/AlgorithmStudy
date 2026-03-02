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
      } else {
        bw.write("NO\n");
      }
      
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
            stack.push(data);
            ans.add('+');
            data++;
          }

          if(stack.isEmpty()) return false;
          if(stack.peek() != order[idx]) return false;

          stack.pop();
          ans.add('-');
          idx++;
      }

      return true;
    }
}