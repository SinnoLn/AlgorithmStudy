import java.util.*;
import java.io.*;

public class Solution {
    static char[][] map;
    static int currDir, currY, currX;
    static int w, h;
    //좌,상,하,우
    static int[] dy = {0,-1,1,0};
    static int[] dx = {-1,0,0,1};
    static List<Character> dirChar = Arrays.asList('<','^','v','>');
    static List<Character> dirWord = Arrays.asList('L','U','D','R');
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        
        map = new char[h][w];
        
        for(int i=0; i<h; i++){
          String s = br.readLine();
          for(int j=0; j<w; j++){
            char c = s.charAt(j);
            if(c == '<' || c == '^' || c == 'v' || c == '>'){
              map[i][j] = '.';
              currDir = dirChar.indexOf(c);
              currY = i;
              currX = j;
            }
            else map[i][j] = c;
          }
        }
        
        int opCnt = Integer.parseInt(br.readLine());
        String op = br.readLine();
        for(int i=0; i<opCnt; i++){
          char c = op.charAt(i);
          if(c == 'S') shoot();
          else {
            int dir = dirWord.indexOf(c);
            move(dir);
          }
        }
        
        // 전차 지도에 넣음
        map[currY][currX] = dirChar.get(currDir);
        
        //출력
        System.out.print("#"+t+" ");
        for(int i=0; i<h; i++){
          for(int j=0; j<w; j++){
            System.out.print(map[i][j]);
          }
          System.out.println();
        }
      }
  }
  
  static void move(int dir){
    currDir = dir;
    int ny = currY + dy[dir];
    int nx = currX + dx[dir];
    
    if(ny < 0 || nx < 0 || ny >= h || nx >= w) return;
    if(map[ny][nx] == '.'){
      currY = ny;
      currX = nx;
    }
  }
  static void shoot(){
    int ny = currY + dy[currDir];
    int nx = currX + dx[currDir];
    while(true){
      if(ny < 0 || nx < 0 || ny >= h || nx >= w) break;
      if(map[ny][nx] == '#') break;
      
      if(map[ny][nx] == '*'){
        map[ny][nx] = '.';
        break;
      }
      ny+=dy[currDir];
      nx+=dx[currDir];
    }
  }
}