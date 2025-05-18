import java.util.*;
import java.io.*;

public class Solution {
    static List<String> numList = Arrays.asList("ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN");
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        String output = st.nextToken();
        int len = Integer.parseInt(st.nextToken());
        
        int num[] = new int[10];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<len; i++){
          String sNum = st.nextToken();
          num[numList.indexOf(sNum)]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; i++){
          int cnt = num[i];
          while(cnt>0){
            sb.append(numList.get(i)).append(" ");
            cnt--;
          }
        }
        System.out.println(output + " " + sb.toString());
      }
  }
}