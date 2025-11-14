import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int[] num = new int[10];
      
      //6->9 9->6
      String s = br.readLine();
      for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(c=='9') num[6]++;
        else num[c-'0']++;
      }
      
      int max = 0;
      for(int i=0; i<10; i++){
        if(i== 6){
          int tmp = num[i]/2;
          if(num[i]%2 != 0) tmp++;
          max = Math.max(max,tmp);
        } 
        else max = Math.max(max, num[i]);
      }
      
      System.out.println(max);
  }
}