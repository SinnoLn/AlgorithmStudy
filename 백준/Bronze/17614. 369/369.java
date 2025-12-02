import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //총 100만번
      int stage = Integer.parseInt(br.readLine());
      //3,6,9
      int[] cnt = new int[10];
      for(int i=1; i<stage+1; i++){
        String num = Integer.toString(i);
        for(int j=0; j<num.length(); j++){
          char c = num.charAt(j);
          if(c == '3' || c == '6' || c == '9') cnt[c-'0']++;
        }
      }
      System.out.println(cnt[3]+cnt[6]+cnt[9]);
  }
}