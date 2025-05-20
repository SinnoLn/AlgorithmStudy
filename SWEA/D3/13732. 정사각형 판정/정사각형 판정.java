import java.util.*;
import java.io.*;

public class Solution {
    static char[][] rec;
    static int minX, minY, maxX, maxY;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int n = Integer.parseInt(br.readLine());
        rec = new char[n][n];
        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        minY = Integer.MAX_VALUE;
        maxY = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
          String input = br.readLine();
          for(int j=0; j<n; j++){
            rec[i][j] = input.charAt(j);
            if(rec[i][j] == '#'){
              minX = Math.min(minX, j);
              maxX = Math.max(maxX, j);
              minY = Math.min(minY, i);
              maxY = Math.max(maxY, i);
            }
          }
        }
        
        if(isRectangle()) System.out.println("#"+t+" "+"yes");
        else System.out.println("#"+t+" "+"no");
      }
  }
  
  static boolean isRectangle(){
    if(maxY-minY != maxX-minX) return false;
    for(int y=minY; y<=maxY; y++){
      for(int x=minX; x<=maxX; x++){
        if(rec[y][x] != '#') return false;
      }
    }
    return true;
  }
}