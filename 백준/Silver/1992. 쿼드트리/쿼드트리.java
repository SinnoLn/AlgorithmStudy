import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      n = Integer.parseInt(br.readLine());
      arr = new int[n][n];
      
      for(int i=0; i<n; i++){
        String s = br.readLine();
        for(int j=0; j<n; j++){
          arr[i][j] = s.charAt(j) - '0';
        }
      }
      
      StringBuilder sb = new StringBuilder();
      compress(0,0,n,sb);
      System.out.println(sb.toString());
  }
  
  static void compress(int y, int x, int size, StringBuilder sb){
    if(isSame(y, x, size)){
      sb.append(arr[y][x]);
      return;
    }
    
    int h = size/2;
    
    sb.append('(');
    compress(y,x,h,sb);
    compress(y,x+h,h,sb);
    compress(y+h,x,h,sb);
    compress(y+h,x+h,h,sb);
    sb.append(')');
  }
  
  static boolean isSame(int y, int x, int size){
    int v = arr[y][x];
    for(int i=y; i<y+size; i++){
      for(int j=x; j<x+size; j++){
        if(arr[i][j] != v) return false;
      }
    }
    return true;
  }
}