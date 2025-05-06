import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      
      for(int i=1; i<n+1; i++){
        String num = Integer.toString(i);
        if(num.contains("3") || num.contains("6") || num.contains("9")){
          for(int s=0; s<num.length(); s++){
            if(num.charAt(s) == '0')continue;
            if((num.charAt(s)-'0')%3==0) bw.write("-");
          }
          bw.write(" ");
        }
        else bw.write(i+" ");
      }
      
      bw.flush();
      bw.close();
      br.close();
  }
}