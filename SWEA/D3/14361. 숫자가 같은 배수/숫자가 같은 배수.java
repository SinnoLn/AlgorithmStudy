import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int num = Integer.parseInt(br.readLine());
        if(isPossible(num)) System.out.println("#"+t+" "+"possible");
        else System.out.println("#"+t+" "+"impossible");
      }
  }
  
  static boolean isPossible(int num){
    int[] numList = new int[10];
    String n = Integer.toString(num);
    for(int i=0; i<n.length(); i++) numList[n.charAt(i)-'0']++;
    
    //2<=k<=9
    for(int k=2; k<10; k++){
      String nn = Integer.toString(num*k);
      if(nn.length() != n.length()) return false;
      
      int[] numList2 = new int[10];
      for(int i=0; i<nn.length(); i++) numList2[nn.charAt(i)-'0']++;
      
      boolean check = true;
      for(int i=0; i<10; i++){
        if(numList[i] != numList2[i]) check = false;
      }
      if(check) return true;
    }
    return false;
  }
}