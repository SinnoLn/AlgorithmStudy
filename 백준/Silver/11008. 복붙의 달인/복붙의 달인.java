import java.util.*;
import java.io.*;


// p 모음을 알고 있을 때 s를 입력하는데 걸리는 최소 시간
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      
      for(int t=0; t<test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String search = st.nextToken();
        String input = st.nextToken();
        
        int count = 0;
        int i = 0 ;
        
        while(i<search.length()){
          if(i+input.length() <= search.length() && search.startsWith(input,i)){
            count++;
            i += input.length();
          }
          else {
            count++;
            i++;
          }
        }
        
        sb.append(count).append("\n");
      }
      System.out.println(sb);
  }
}