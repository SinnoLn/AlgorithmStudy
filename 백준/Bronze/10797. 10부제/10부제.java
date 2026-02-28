import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      //자동차 번호 일의자리 != 날짜 일의자리
      //위반 자동차 개수
      int[] arr = new int[10];
      for(int i=0; i<5; i++){
        int num = Integer.parseInt(st.nextToken());
        arr[num]++;
      }
      System.out.println(arr[n]);
    }
}