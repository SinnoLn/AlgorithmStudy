import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //도착지까지 이동 가능한 최소비용
      //long 사용
      int n = Integer.parseInt(br.readLine());
      
      //O(10만)
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] dist = new int[n-1]; //0-index
      for(int i=0; i<n-1; i++){
        int num = Integer.parseInt(st.nextToken());
        dist[i] = num;
      }
      
      //O(10만)
      long pay = 0L;
      long maxPay = Integer.MAX_VALUE;
      int currPay = 0;
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n-1; i++){
        int num = Integer.parseInt(st.nextToken());
        if(maxPay>num){
          pay+=dist[i]*num;
          maxPay = num;
        }
        else pay+=maxPay*dist[i];
      }
      
      System.out.println(pay);
    }
}