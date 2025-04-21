import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //뒤부터 출발
      //첫 수 저장, 만약 더 작다면 사고, 개수 증가
      //그렇게 사다가 현재값보다 같거나 더 큰값 나오면, 팔고, 다시 그값 저장
      //0까지 갈때까지 반복
      //100만이니 for문 1번으로 끝내야함
      
      int test = Integer.parseInt(br.readLine());
      for(int i=0; i<test; i++){
        int day = Integer.parseInt(br.readLine());
        int[] chart = new int[day];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j=0; j<day; j++) chart[j] = Integer.parseInt(st.nextToken());
        
        int exPay = -1; //현재기준 가장 높은 가격
        int count = 0; //현재까지 구매한 개수
        long sum = 0; //현재까지 구매하는데 든 비용
        long ans = 0; // 총 이득

        for(int d=chart.length-1; d > -1; d--){
          if(exPay == -1) {
            exPay = chart[d];
            continue;
          }
          
          int currPay = chart[d];
          //현재 가격이 이전 가격보다 높거나 같다면
          if(currPay>=exPay){
            ans += (count*exPay - sum);
            count = 0;
            exPay = currPay;
            sum = 0;
            continue;
          }
          
          count++;
          sum+= currPay;
        }
        //아직 정산 안한거 계산
        if(count > 0) ans += (count*exPay - sum);
        System.out.println("#"+(i+1)+" "+ans);
      }
  }
}