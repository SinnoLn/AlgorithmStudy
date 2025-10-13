import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //최소한으로 점수 내리기
      //뒤부터 체크
      int n = Integer.parseInt(br.readLine());
      int[] point = new int[n];
      for(int i=0; i<n; i++){
        point[i] = Integer.parseInt(br.readLine());
      }
      
      int sum = 0;
      //n-1부터 1까지
      for(int i=n-1; i>0; i--){
        if(point[i]<=point[i-1]){
          sum += point[i-1] - point[i] + 1;
          point[i-1] = point[i]-1;
        }
      }
      System.out.println(sum);
  }
}