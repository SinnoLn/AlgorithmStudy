import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
      String input = br.readLine();
      int n = Integer.parseInt(br.readLine());
      
      //모두 소문자
      int[][] prefixSum = new int[input.length()+1][26];
      
      //2000*2000*26 -> 1억이 안넘긴 한데..
      for(int i=1; i<=input.length(); i++){
        char c = input.charAt(i-1);
        for(int j=0; j<26; j++){
          prefixSum[i][j] = prefixSum[i-1][j];
        }
        prefixSum[i][c-'a']++;
      }
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        char c = st.nextToken().charAt(0);
        int a = Integer.parseInt(st.nextToken())+1;
        int b = Integer.parseInt(st.nextToken())+1;
        
        sb.append(prefixSum[b][c-'a'] - prefixSum[a-1][c-'a']).append('\n');
      }
      
      System.out.println(sb);
    }
}