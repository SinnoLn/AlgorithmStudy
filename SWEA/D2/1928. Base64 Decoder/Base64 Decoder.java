import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int test=1; test<=t; test++){
          String encoded = br.readLine();
          StringBuilder binary = new StringBuilder();
          
          for(int i=0; i<encoded.length(); i++){
            char c  = encoded.charAt(i);
            int num = base64(c);
            binary.append(toBinary(num, 6));
          }
          
          StringBuilder decoded = new StringBuilder();
           for (int i = 0; i + 8 <= binary.length(); i += 8) {
                String byteStr = binary.substring(i, i + 8);
                int charCode = Integer.parseInt(byteStr, 2); 
                decoded.append((char)charCode);
            }

            System.out.println("#" + test + " " + decoded.toString());
        }
    }
    static int base64(char c){
      //소문자
      if(c <= 'z' && c >= 'a') return c-'a'+26;
      //대문자
      else if(c <='Z' && c >='A') return c-'A';
      //숫자
      else if(c <= '9' && c >= '0') return c-'0'+52;
      //기호
      else if(c == '+') return 62;
      else if(c == '/') return 63;
      
      return 0;
    }
    
    static String toBinary(int num, int length) {
        StringBuilder bin = new StringBuilder();
        while (num > 0) {
            bin.insert(0, num % 2);
            num /= 2;
        }
        while (bin.length() < length) {
            bin.insert(0, "0");
        }
        return bin.toString();
    }
}