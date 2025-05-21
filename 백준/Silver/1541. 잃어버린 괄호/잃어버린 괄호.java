import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input = br.readLine();
      List<String> cal = new ArrayList<>();

      StringBuilder sb = new StringBuilder();
      for(int i=0; i<input.length(); i++){
        char o = input.charAt(i);
        
        if(o == '-' || o == '+') {
          cal.add(sb.toString());
          cal.add(String.valueOf(o));
          sb = new StringBuilder();
        }
        else sb.append(o);
      }
      cal.add(sb.toString());
      
      int sum = 0;
      int m = 1;
      boolean isCheck = false;
      
      for(int i=0; i<cal.size(); i++){
        String s = cal.get(i);
        
        if(s.equals("-")){
            isCheck = true;
        } else if(s.equals("+")){
            continue; 
        } else {
            int num = Integer.parseInt(s);
            if(isCheck) sum -= num;
            else sum += num;
        }
    }
    System.out.println(sum);
  }
}