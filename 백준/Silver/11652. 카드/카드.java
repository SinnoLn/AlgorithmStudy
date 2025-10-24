import java.util.*;
import java.io.*;

public class Main {
  //-2^62 ~ 2^62 long 범위
  //최대 10만개의 카드
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      Map<Long,Integer> map = new HashMap<>();
      Long minNum = Long.MAX_VALUE;
      int maxCnt = 0;
      
      for(int i=0; i<n; i++){
        Long l = Long.parseLong(br.readLine());
        if(map.containsKey(l)){
          map.put(l,map.get(l)+1);
        }
        else map.put(l,1);
        
        int cnt = map.get(l)+1;
        if(cnt>maxCnt){
          minNum = l;
          maxCnt = cnt;
        }
        else if(cnt == maxCnt){
          minNum = Math.min(minNum, l);
        }
      }
      
      System.out.println(minNum);
  }
}