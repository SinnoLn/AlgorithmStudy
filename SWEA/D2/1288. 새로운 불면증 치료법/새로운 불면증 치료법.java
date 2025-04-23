import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for(int test = 1; test<=t; test++){
        //n번째 양을 셌을때 n번째에서 모든 숫자 0,9 모두 봤을때 체크
        //long을 쓸 필요가 있는지 체크
        int n = Integer.parseInt(br.readLine());
        int[] check = new int[10];
        int tmp = 1;
        int cnt = 0;
        int index = 1;
        while(true){
          tmp = index*n;
          index++;
          
          String s = Integer.toString(tmp);
          for(int j=0; j<s.length(); j++){
            check[s.charAt(j)-'0']++;
            if(check[s.charAt(j)-'0']==1) cnt++;
          }
          if(cnt == 10) break;
        }
        System.out.println("#"+test+" "+tmp);
      }
  }
}