import java.util.*;
import java.io.*;

//dp
public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      int[][] map = new int[n][3];
      
      for(int i=0; i<n; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int j=0; j<3; j++){
          int num = Integer.parseInt(st.nextToken());
          map[i][j] = num;
        }
      }
      
      //로직 시작
      //그 위치에 있을때 최소, 최대
      int[] maxDP = new int[3];
      int[] minDP = new int[3];
      
      maxDP[0] = minDP[0] = map[0][0];
      maxDP[1] = minDP[1] = map[0][1];
      maxDP[2] = minDP[2] = map[0][2];
      
      for(int i=1; i<n; i++){
        int[]p = new int[3];
        int[]q = new int[3];
        
        p[0] = maxDP[0];
        p[1] = maxDP[1];
        p[2] = maxDP[2];
        
        q[0] = minDP[0];
        q[1] = minDP[1];
        q[2] = minDP[2];
        
        maxDP[0] = map[i][0] + Math.max(p[0],p[1]);
        maxDP[1] = map[i][1] + Math.max(p[0], Math.max(p[1], p[2]));
        maxDP[2] = map[i][2] + Math.max(p[2], p[1]);
        
        minDP[0] = map[i][0] + Math.min(q[1],q[0]);
        minDP[1] = map[i][1] + Math.min(q[0], Math.min(q[1], q[2]));
        minDP[2] = map[i][2] + Math.min(q[2], q[1]);
      }
      
      int minAns = Math.min(minDP[0], Math.min(minDP[1], minDP[2]));
      int maxAns = Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]));
      
      System.out.println(maxAns + " " + minAns);
    }
}