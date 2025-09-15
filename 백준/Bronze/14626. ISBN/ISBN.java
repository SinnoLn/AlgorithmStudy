import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      
      int[] passwd = new int[13];
      int idx = 0;
      for(int i=0; i<13; i++){
        if(s.charAt(i) == '*') idx = i;
        else passwd[i] = s.charAt(i)-'0';
      }
      
      //정합성 체크
      int[] multi = {1,3};
      int sum = 0;
      if(idx == 12){
        for(int i=0; i<12; i++){
          sum += passwd[i]*multi[(i+2)%2];
        }
        System.out.println(10-sum%10);
      }
      else{
        int w = 0;
        for(int i=0; i<12; i++){
            if(i == idx){
                w = multi[(i+2)%2];
                continue;
            }
            sum += passwd[i]*multi[(i+2)%2];
        }
    
        int need = (10 - ((sum + passwd[12]) % 10)) % 10; 
    
        int x;
        if (w == 1) x = need;
        else x = (need * 7) % 10; 
    
        System.out.println(x);
    }
  }
}