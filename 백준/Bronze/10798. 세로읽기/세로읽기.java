import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] list = new String[5];
      
      int x = 0;
      for(int i=0; i<5; i++){
        String word = br.readLine();
        list[i] = word;
        x = Math.max(x, word.length());
      }
      
      char[][] wordList = new char[5][x];
      for(int i=0; i<5; i++){
        for(int j=0; j<x; j++){
          if(j<list[i].length()) wordList[i][j] = list[i].charAt(j);
          else wordList[i][j] = ' ';
        }
      }
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<x; i++){
        for(int j=0; j<5; j++){
          if(wordList[j][i] == ' ') continue;
          sb.append(wordList[j][i]);
        }
      }
      System.out.println(sb.toString());
  }
}