import java.util.*;
import java.io.*;


// p 모음을 알고 있을 때 s를 입력하는데 걸리는 최소 시간
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=0; t<test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String search = st.nextToken();
        String input = st.nextToken();
        
        StringBuilder sb = new StringBuilder(search);
        while(sb.indexOf(input) != -1){
          int pos = sb.indexOf(input);
          sb.delete(pos, pos+input.length());
          sb.insert(pos,0);
        }
        
        System.out.println(sb.length());
      }
  }
}