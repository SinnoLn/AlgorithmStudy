import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      //최대 10만개의 숫자
      //중복?
      //100만 크기의 배열은 불가
      //O(20만)
      //중복고려하면 Map으로 개수 추가
      //ai + aj = x (1 ≤ i < j ≤ n)
      
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> list = new ArrayList<>();
      for(int i=0; i<n; i++){
        int num = Integer.parseInt(st.nextToken());
        if(map.containsKey(num)) {
          map.put(num, map.get(num)+1);
        }
        else{
          map.put(num, 1);
          list.add(num);
        } 
      }
      
      int x = Integer.parseInt(br.readLine());
      
      int ans = 0;
      //0부터 탐색 합이 된다면 계산 후 0으로 변경
      for(int i=0; i<list.size(); i++){
        int currNum = list.get(i);
        if(currNum == x-currNum) continue;
        if(map.containsKey(currNum) && map.containsKey(x-currNum)){
          ans += map.get(currNum)*map.get(x-currNum);
          map.remove(x-currNum);
        }
      }
      
      System.out.println(ans);
  }
}