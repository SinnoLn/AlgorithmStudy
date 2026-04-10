import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //long 범위
      PriorityQueue<Integer> minus = new PriorityQueue<>((a,b)->b-a);
      PriorityQueue<Integer> plus = new PriorityQueue<>();
      int zeroCnt = 0;
      int oneCnt = 0;
      long ans = 0L;
      
      int n = Integer.parseInt(br.readLine());
      for(int i=0; i<n; i++){
        int num = Integer.parseInt(br.readLine());
        if(num == 0) zeroCnt++;
        else if(num == 1) oneCnt++;
        else if(num>0) plus.add(num);
        else minus.add(num);
      }
      
      ans+=oneCnt;
      
      //마이너스 계산
      int cnt = 2;
      int multi = 1;
      int leftNum = 0;
      if(minus.size()%2==1) leftNum = minus.poll();
      while(!minus.isEmpty()){
        int tmp = minus.poll();
        cnt--;
        multi*=tmp;
        if(cnt == 0){
          ans+=multi;
          multi = 1;
          cnt = 2;
        }
      }
      
      //플러스 계산
      cnt = 2;
      multi = 1;
      if(plus.size()%2==1) ans+=plus.poll();
      while(!plus.isEmpty()){
        int tmp = plus.poll();
        cnt--;
        multi*=tmp;

        if(cnt == 0){
          ans+=multi;
          multi = 1;
          cnt = 2;
        }
      }
      
      //최종 정리
      if(leftNum != 0 && zeroCnt == 0) ans+=leftNum;
      System.out.println(ans);
    }
}