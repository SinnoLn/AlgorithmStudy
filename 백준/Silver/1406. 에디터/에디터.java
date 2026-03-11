import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //왼쪽 커서
      //오른쪽 커서?
      //커서 기준으로 왼쪽에 위치하는 문자, 오른쪽에 위치하는 문자
      String input = br.readLine();
      int n = Integer.parseInt(br.readLine());
      Deque<Character> leftDq = new ArrayDeque<>();
      Deque<Character> rightDq = new ArrayDeque<>();
      
      for(int i=0; i<input.length(); i++){
        leftDq.addLast(input.charAt(i));
      }
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        char op = st.nextToken().charAt(0);
        
        if(op == 'L'){
          if(leftDq.isEmpty()) continue;
          char c = leftDq.pollLast();
          rightDq.addFirst(c);
        }
        else if(op == 'D'){
          if(rightDq.isEmpty()) continue;
          char c = rightDq.pollFirst();
          leftDq.addLast(c);
        }
        else if(op == 'B'){
          if(leftDq.isEmpty()) continue;
          leftDq.pollLast();
        }
        else{
          char c = st.nextToken().charAt(0);
          leftDq.addLast(c);
        }
      }
      
      StringBuilder sb = new StringBuilder();
      
      while(!leftDq.isEmpty()){
        sb.append(leftDq.pollFirst());
      }
      while(!rightDq.isEmpty()){
        sb.append(rightDq.pollFirst());
      }
      
      System.out.println(sb.toString());
    }
}