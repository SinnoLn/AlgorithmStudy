import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //반반 두마리 -> 후라이드1 + 양념1
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      
      int diff = 0;
      //양념 a, 후라이드 b, 반반 c
      if(x<y) diff = x;
      else diff = y;
      
      x-=diff;
      y-=diff;
      
      if(c*2 < a+b){
        int sum = c*2*diff;
        if((x+y)*c*2 < (x*a + y*b)) System.out.println(sum + (x+y)*c*2);
        else System.out.println(sum + x*a + y*b);
      }
      else System.out.println(a*(x+diff) + b*(y+diff));
      
      //1000원 90000*1000 = 900만
      //후라이드 10000개 남음
      //그러나 반반 10000개 사도 100만원이라 더 쌈
  }
}