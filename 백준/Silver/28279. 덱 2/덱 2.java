import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
          if(dq.isEmpty()) System.out.println(-1);
          else System.out.println(dq.removeFirst());
        }
        else if(op == 4){
          if(dq.isEmpty()) System.out.println(-1);
          else System.out.println(dq.removeLast());
        }
        else if(op == 5){
          System.out.println(dq.size());
        }
        else if(op == 6){
          if(dq.isEmpty()) System.out.println(1);
          else System.out.println(0);
        }
        else if(op == 7){
          if(dq.isEmpty()) System.out.println(-1);
          else System.out.println(dq.peekFirst());
        }
        else{
          if(dq.isEmpty()) System.out.println(-1);
          else System.out.println(dq.peekLast());
        }
      }
    }
}