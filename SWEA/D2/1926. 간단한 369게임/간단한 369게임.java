import java.util.*;
import java.io.*;

public class Solution {
  //369게임 박수침
  //박수는 해당 숫자가 들어간 수만큼 박수침
  //- -- ---
  //1부터 최대 1000의 숫자
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine())+1;
      String ans = "";
      
      for(int i=1; i<n; i++){
        String s = Integer.toString(i);
        int[] num = new int[10];
        int sum = 0;
        
        for(int j=0; j<s.length(); j++){
          num[s.charAt(j)-'0']++;
        }
        sum = num[3] + num[6] + num[9];
        
        if(sum>0){
          for(int m=0; m<sum; m++) ans+='-';
        }
        else ans+=s;
        
        ans+=' ';
      }
      System.out.println(ans);
  }
}