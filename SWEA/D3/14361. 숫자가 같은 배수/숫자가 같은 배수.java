import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        if(isPossible(n)) System.out.println("#"+t+" "+"possible");
        else System.out.println("#"+t+" "+"impossible");
      }
  }
  
  static boolean isPossible(int num){
    String sNum = Integer.toString(num);
    int[] numList = new int[10];
    for(int i=0; i<sNum.length(); i++) numList[sNum.charAt(i)-'0']++;
    
    for(int i=2;i<10; i++){
      int multiNum = num*i;
      String sMultiNum = Integer.toString(multiNum);
      boolean check = true;
       
      if(sNum.length() != sMultiNum.length()) return false;
      
      int[] numList2 = new int[10];
      for(int j=0; j<sMultiNum.length(); j++) numList2[sMultiNum.charAt(j)-'0']++;
      
      for(int k=0; k<10; k++){
        if(numList[k] != numList2[k]) check = false;
      }
      if(check) return true;
    }
    
    return false;
  }
}