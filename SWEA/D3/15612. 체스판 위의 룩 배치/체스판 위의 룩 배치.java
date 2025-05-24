import java.io.*;
import java.util.*;

public class Solution {
	static char[][] chess;
	static int cnt;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
      int test = Integer.parseInt(br.readLine());
      for(int t=1; t<=test; t++) {
    	 chess = new char[8][8];
    	 cnt = 0;
    	 
    	 for(int i=0; i<8; i++) {
    		 String s = br.readLine();
    		 for(int j=0; j<8; j++) {
    			 chess[i][j] = s.charAt(j);
    			 if(chess[i][j]== 'O')cnt++;
    		 }
    	 }
    	 if(checkPossible()) System.out.println("#"+t+" "+"yes");
    	 else System.out.println("#"+t+" "+"no");
      }
  }
    static boolean checkPossible(){
    	if(cnt != 8) return false;
    	for(int i=0; i<8; i++) {
    		int cntCol = 0;
    		int cntRow = 0;
    		for(int j=0; j<8; j++) {
    			if(chess[i][j] == 'O')cntCol++;
    			if(chess[j][i] == 'O')cntRow++;
    		}
    		if(cntCol != 1 || cntRow != 1) return false;
    	}
    	return true;
    }
}
