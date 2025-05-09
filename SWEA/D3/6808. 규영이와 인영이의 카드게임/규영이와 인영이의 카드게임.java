import java.util.*;
import java.io.*;

public class Solution {
    //362880
    //dfs
    //dp
    static List<Integer> cardA = new ArrayList<>();
    static List<Integer> cardB = new ArrayList<>();
    static boolean[] check;
    static boolean[] visited;
    static int[] selected;
    static int win, lose;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        check = new boolean[19];
        visited = new boolean[9];
        selected = new int[9];
        cardA.clear();
        cardB.clear();
        
        for(int i=0; i<9; i++) {
          int num = Integer.parseInt(st.nextToken());
          cardA.add(num);
          check[num] = true;
        }
        for(int i=1; i<=18; i++){
          if(!check[i]) cardB.add(i);
        }
        
        win = 0;
        lose = 0;
        dfs(0);
        
        System.out.println("#"+t+" "+win+" "+lose);
      }
  }
  
  static void dfs(int depth){
    if(depth == 9){
      countWinner();
      return;
    }
    for(int i=0; i<9; i++){
      if(visited[i]) continue;
      visited[i] = true;
      selected[depth] = cardB.get(i);
      dfs(depth+1);
      visited[i] = false;
    }
  }
  
  static void countWinner(){
    int aScore = 0;
    int bScore = 0;
    for(int i=0; i<9; i++){
      int a = cardA.get(i);
      int b = selected[i];
      
      if(a>b) aScore+=(a+b);
      else bScore+=(a+b);
    }
    if(aScore > bScore) win++;
    else if(aScore < bScore) lose++;
  }
}