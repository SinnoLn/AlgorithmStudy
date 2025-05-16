import java.util.*;
import java.io.*;

public class Solution {
    static int n;
    static char[][] rectangle;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++){
        n = Integer.parseInt(br.readLine());
        rectangle = new char[n][n];
        
        for(int i=0; i<n; i++){
          rectangle[i] = br.readLine().toCharArray();
        }
        String ans = isRectangle();
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static String isRectangle(){
    int startY = 10000;
    int startX = 10000;
    int endX = 0;
    int endY = 0;
    
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(rectangle[i][j] == '#'){
          startY = Math.min(startY, i);
          startX = Math.min(startX, j);
          endY = Math.max(endY, i);
          endX = Math.max(endX, j);
        }
      }
    }
    
    if(startY - endY != startX - endX) return new String("no");
    for(int i=startY; i<=endY; i++){
      for(int j=startX; j<=endX; j++){
        if(rectangle[i][j] != '#') return new String("no");
      }
    }
    return new String("yes");
  }
}