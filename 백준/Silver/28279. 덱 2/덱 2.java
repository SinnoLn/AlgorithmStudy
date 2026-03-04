import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      Deque<Integer> dq = new ArrayDeque<>();
      
      int n = Integer.parseInt(br.readLine());
      for(int i=0; i<n; i++){
        String[] nums = br.readLine().split(" ");
        int op = Integer.parseInt(nums[0]);
        
        //로직 시작
        if(op == 1){
          int num = Integer.parseInt(nums[1]);
          dq.addFirst(num);
        }
        else if(op == 2){
          int num = Integer.parseInt(nums[1]);
          dq.addLast(num);
        }
        else if(op == 3){
          if(dq.isEmpty()) sb.append(-1).append('\n');
          else sb.append(dq.removeFirst()).append('\n');
        }
        else if(op == 4){
          if(dq.isEmpty()) sb.append(-1).append('\n');
          else sb.append(dq.removeLast()).append('\n');
        }
        else if(op == 5){
          sb.append(dq.size()).append('\n');
        }
        else if(op == 6){
          if(dq.isEmpty()) sb.append(1).append('\n');
          else sb.append(0).append('\n');
        }
        else if(op == 7){
          if(dq.isEmpty()) sb.append(-1).append('\n');
          else sb.append(dq.peekFirst()).append('\n');
        }
        else{
          if(dq.isEmpty()) sb.append(-1).append('\n');
          else sb.append(dq.peekLast()).append('\n');
        }
      }
      
      System.out.println(sb.toString());
    }
}