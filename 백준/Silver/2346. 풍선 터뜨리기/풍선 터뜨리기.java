import java.util.*;
import java.io.*;

//원형 큐
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      Deque<int[]> dq = new ArrayDeque<>();
      
      for(int i=0; i<n; i++){
        int num = Integer.parseInt(st.nextToken());
        dq.addLast(new int[]{i+1, num});
      }
      
      //로직 시작
      StringBuilder sb = new StringBuilder();
      
      //먼저 터트리기
      int[] current = dq.removeFirst();
      sb.append(current[0]).append(" ");
      int move = current[1];
      
      while(!dq.isEmpty()){
        if(move>0){
          //n-1번 이동
          for(int i=1; i<move; i++){
            current = dq.removeFirst();
            dq.addLast(current);
          }
          current = dq.removeFirst();
          sb.append(current[0]).append(" ");
          move = current[1];
        }
        else{
          //n-1번 이동
          for(int i=move; i<-1; i++){
            current = dq.removeLast();
            dq.addFirst(current);
          }
          current = dq.removeLast();
          sb.append(current[0]).append(" ");
          move = current[1];
        }
      }
      System.out.println(sb.toString());
    }
}