import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //매수해야 하는 사람의 최솟값
      //다솜은 기호 1번
      int n = Integer.parseInt(br.readLine());
      int dasom = Integer.parseInt(br.readLine());
      
      //예외케이스
      if(n == 1){
        System.out.println(0);
        return;
      }
      
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      
      for(int i=0; i<n-1; i++){
        int num = Integer.parseInt(br.readLine());
        pq.add(num);
      }
      
      //최대 50명
      //득표수는 최대 100표
      int ans = 0;
      while(pq.peek()>=dasom){
        int winner = pq.poll();
        pq.add(winner-1);
        dasom++;
        ans++;
      }
      
      System.out.println(ans);
    }
}