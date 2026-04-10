import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //모든 숫자를 전부 같게만들기
      //최대 100만 길이의 문자열
      String input = br.readLine();
      
      char curr = input.charAt(0);
      int zeroCnt = 0;
      int oneCnt = 0;
      if(curr == '0') zeroCnt++;
      else oneCnt++;
      
      for(int i=1; i<input.length(); i++){
        char c = input.charAt(i);
        
        if(curr == c) continue;
        if(c == '0') zeroCnt++;
        else oneCnt++;
        curr = c;
      }
      
      int ans = Math.min(zeroCnt, oneCnt);
      System.out.println(ans);
    }
}