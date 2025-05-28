import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int n,l;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      n = Integer.parseInt(st.nextToken());
      l = Integer.parseInt(st.nextToken());
      map = new int[n][n];
      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine()); 
        for(int j=0; j<n; j++){
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      int ans = findRoute();
      System.out.println(ans);
  }
  
  static int findRoute(){
    int cnt = 0;
    //행 탐색
    for(int i=0; i<n; i++){
      int[] line = map[i];
      if(canUseRamp(line)) cnt++;
    }
    //열 탐색
    for(int i=0; i<n; i++){
      int[] line = new int[n];
      for(int j=0; j<n; j++){
        line[j] = map[j][i];
      }
      if(canUseRamp(line)) cnt++;
    }
    
    return cnt;
  }
  
  static boolean canUseRamp(int[] line){
    boolean[] used = new boolean[n];
    
    for(int i=0; i<n-1; i++){
      if(line[i] == line[i+1]) continue;
      else if(line[i] - line[i+1] == 1){
        for(int j=1; j<=l; j++){
          if(i+j>=n) return false;
          if(line[i+1] != line[i+j]) return false;
          if(used[i+j]) return false;
          used[i+j] = true;
        }
      }
      else if(line[i] - line[i + 1] == -1){
        for(int j=0; j<l; j++){
          if(i-j<0) return false;
          if(line[i] != line[i-j]) return false;
          if(used[i-j]) return false;
          used[i-j] = true;
        }
      } else return false;
    }
    return true;
  }
}