import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());

      for(int t=1; t<=test; t++){
        String s = br.readLine();
        StringBuilder binary = new StringBuilder();
        for(int i=0; i<s.length(); i++){
          int num = base64(s.charAt(i));
          binary.append(toBinary(num, 6));
        }
        
       StringBuilder decoded = new StringBuilder();
       for(int i=0; i+8<=binary.length(); i+=8){
         String byteStr = binary.substring(i, i+8);
         int charCode = Integer.parseInt(byteStr, 2);
         decoded.append((char)charCode);
       }
        System.out.println("#" + t + " " + decoded.toString());
      }
  }
  
  static int base64(char c){
    if(c >= 'a' && c <= 'z') return c - 'a'+ 26;
    else if(c >= 'A' && c <= 'Z') return c -'A';
    else if(c <= '9' && c >= '0') return c-'0'+52;
    else if (c == '+') return 62;
    else return 63;
  }
  
  static String toBinary(int num, int len){
    StringBuilder bin = new StringBuilder();
    while(num>0){
      bin.insert(0, num%2);
      num/=2;
    }
    while(bin.length() < len){
      bin.insert(0,"0");
    }
    return bin.toString();
  }
}