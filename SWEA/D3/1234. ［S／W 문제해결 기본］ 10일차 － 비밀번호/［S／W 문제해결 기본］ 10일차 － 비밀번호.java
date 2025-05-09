import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> num = new ArrayList<>();
        
        String s = st.nextToken();
        for(int i=0; i<n; i++){
          num.add(s.charAt(i)-'0');
        }
        
        while(true){
          boolean check = true;
          for(int i=0; i<num.size()-1; i++){
            if(num.get(i) == num.get(i+1)){
              check = false;
              num.remove(i);
              num.remove(i);
            }
          }
          if(check) break;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : num) sb.append(Integer.toString(i));
        System.out.println("#"+t+" "+sb.toString());
      }
  }
}