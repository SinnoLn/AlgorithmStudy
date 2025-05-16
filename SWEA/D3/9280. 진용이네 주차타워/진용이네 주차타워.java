import java.util.*;
import java.io.*;

public class Solution {
    static PriorityQueue<Integer> emptySpace = new PriorityQueue<>();
    static Queue<Integer> waiting = new LinkedList<>();
    static int[] fees;
    static int[] weights;
    static int[] parkedPosition;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //i번 주차공간 무게 단위당 요금 R
        int m = Integer.parseInt(st.nextToken()); //차량 i의 무게
        
        //초기화
        emptySpace.clear();
        waiting.clear();
        fees = new int[n+1];
        weights = new int[m+1];
        parkedPosition = new int[m+1];
        
        for(int i=1; i<n+1; i++) fees[i] = Integer.parseInt(br.readLine());
        for(int i=1; i<m+1; i++) weights[i] = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) emptySpace.add(i+1);
        
        //주차장 운영 시작
        //차량의 무게 * 주차 공간마다 따로 책정된 단위 무게당 금액
        int sum = 0;
        for(int i=0; i<2*m; i++){
          int car = Integer.parseInt(br.readLine());
          if(car>0){
            if(emptySpace.isEmpty()) waiting.add(car);
            else{
              int space = emptySpace.poll();
              sum += weights[car]*fees[space];
              parkedPosition[car] = space;
            }
          }
          else{
            emptySpace.add(parkedPosition[-car]);
            parkedPosition[-car] = 0;
            if(!waiting.isEmpty()){
              int nextCar = waiting.poll();
              int space = emptySpace.poll();
              sum += weights[nextCar]*fees[space];
              parkedPosition[nextCar] = space;
            }
          }
        }
        System.out.println("#"+t+" "+sum);
      }
  }
}