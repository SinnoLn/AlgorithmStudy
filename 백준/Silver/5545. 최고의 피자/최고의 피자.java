import java.util.*;
import java.io.*;

//최고의 피자의 1원 당 열량을 구하는 프로그램
//주문할 수 있는 피자 중 1원당 열량이 가장 높은 피자
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()); //도우 가격
      int b = Integer.parseInt(st.nextToken()); //토핑 가격
      int c = Integer.parseInt(br.readLine()); //도우 열량
      
      // 각 토핑의 열량 
      int[] cal = new int[n];
      for(int i=0; i<n; i++){
        cal[i] = Integer.parseInt(br.readLine());
      }
      
      //1원당 열량이 가장 높아야함
      int calSum = c;
      int price = a;
      
      //토핑이 없을 경우 답
      int ans = c/a;
      
      Arrays.sort(cal);
      
      int currPrice = a;
      int currCal = c;

      for(int i=n-1; i>=0; i--){
        currPrice+=b;
        currCal+=cal[i];
        if(ans<currCal/currPrice){
          ans = Math.max(ans,currCal/currPrice);
        }
      }
      System.out.println(ans);
  }
}