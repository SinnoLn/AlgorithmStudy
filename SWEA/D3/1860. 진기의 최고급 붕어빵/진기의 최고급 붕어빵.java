import java.util.*;
import java.io.*;

public class Solution {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int n,m,k,max;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        //최댓값 초기화
        max = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          int num = Integer.parseInt(st.nextToken());
          max = Math.max(num, max);
          if(map.containsKey(num)){
            map.put(num, map.get(num)+1);
          }
          else map.put(num, 1);
        }
        
        if(checkPossible()) System.out.println("#"+t+" "+"Possible");
        else System.out.println("#"+t+" "+"Impossible");
        
        map.clear();
      }
  }
  static boolean checkPossible(){
    //m초 지날때마다 k개 붕어빵 생성
    //시뮬레이션
    int time = 0;
    int fishbread=0;
    int index = 0;
    //0초에 오는 손님 예외처리
    if(map.containsKey(0)) return false;
    
    while(true){
      time++;
      if(time > max) break;
      if(time%m==0) fishbread+=k;
      if(map.containsKey(time)){
        fishbread-=map.get(time);
      }
      if(fishbread<0) return false;
    }
    return true;
  }
}