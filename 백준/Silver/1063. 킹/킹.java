import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[8][8]; //고정
    static int[] kPos = new int[2];
    static int[] stonePos = new int[2];
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      String kP = st.nextToken();
      String stoneP = st.nextToken();
      int moveCnt = Integer.parseInt(st.nextToken());
      
      //1,a -> (0,0) , 8,h -> (7,7)
      kPos[0] = kP.charAt(1) - '0' -1;
      kPos[1] = kP.charAt(0) - 'A';
      
      stonePos[0] = stoneP.charAt(1) - '0' -1;
      stonePos[1] = stoneP.charAt(0) - 'A';
      
      for(int i=0; i<moveCnt; i++){
        //King이 움직여야 Stone이동
        //범위를 벗어날 경우 그대로
        String moveDir = br.readLine();
        moveKingAndStone(moveDir);
      }
       
      String finalKingPos = (char)(kPos[1]+'A') +""+ (char)(kPos[0]+'0'+1); 
      String finalStonePos = (char)(stonePos[1]+'A') +""+ (char)(stonePos[0]+'0'+1);
        
      System.out.println(finalKingPos);
      System.out.println(finalStonePos);
    }
    
    static void moveKingAndStone(String dir){
      int[] move = new int[2];
      if(dir.equals("R")){
        move[1] = 1;
      }
      else if(dir.equals("L")){
        move[1] = -1;
      }
      else if(dir.equals("B")){
        move[0] = -1;
      }
      else if(dir.equals("T")){
        move[0] = 1;
      }
      else if(dir.equals("RT")){
        move[0] = 1;
        move[1] = 1;
      }
      else if(dir.equals("LT")){
        move[0] = 1;
        move[1] = -1;
      }
      else if(dir.equals("RB")){
        move[0] = -1;
        move[1] = 1;
      }
      else if(dir.equals("LB")){
        move[0] = -1;
        move[1] = -1;
      }
      
      //King 먼저
      int nextY = move[0] + kPos[0];
      int nextX = move[1] + kPos[1];
      
      if(nextY < 0 || nextX < 0 || nextY >= 8 || nextX >= 8) return;
      
      if(nextY == stonePos[0] && nextX == stonePos[1]) {
        int nextSY = stonePos[0] + move[0];
        int nextSX = stonePos[1] + move[1];
        
        if(nextSY < 0 || nextSX < 0 || nextSY >= 8 || nextSX >= 8) return;
        
        stonePos[0] = nextSY;
        stonePos[1] = nextSX;
      }
      
      kPos[0] = nextY;
      kPos[1] = nextX;
    }
}