import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      
      char[][] map = new char[n][m];
      for(int i=0; i<n; i++){
        String input = br.readLine();
        for(int j=0; j<m; j++){
          map[i][j] = input.charAt(j);
        }
      }
      
      String[] ans = new String[m];
      for(int i=0; i<m; i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<n; j++){
          char c = map[j][i];
          
          if(c == '-') c = '|';
          else if(c == '|') c = '-';
          else if(c == '/') c = '\\';
          else if(c == '\\') c = '/';
          else if(c == '^') c = '<';
          else if(c == '<') c = 'v';
          else if(c == 'v') c = '>';
          else if(c == '>') c = '^';
          
          sb.append(c);
        }
        ans[i] = sb.toString();
      }
      
      for(int i=m-1; i>=0; i--){
        System.out.println(ans[i]);
      }
  }
}