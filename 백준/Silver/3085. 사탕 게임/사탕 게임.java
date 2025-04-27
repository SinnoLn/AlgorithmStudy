import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] board;
    public static void main(String[] args) throws IOException{
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      board = new char[n][n];
      
      for(int i=0; i<n; i++){
        board[i] = br.readLine().toCharArray();
      }
      
      //오른쪽, 아래만 탐색
      int[] dy = {0,1};
      int[] dx = {1,0};
      int max = 0;
      for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
          for(int dir = 0; dir<2; dir++){
            int ny = i + dy[dir];
            int nx = j + dx[dir];
            //범위 넘으면 통과
            if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            //색깔 같으면 통과
            if(board[i][j] == board[ny][nx]) continue;
            //일단 swap하고
            swap(i,j, ny, nx);
            //가장긴 열 혹은 행 탐색
            max = Math.max(max, searchMaxLen());
            if(max == n){
              System.out.println(n);
              return;
            }
            //다시 원래대로
            swap(i,j, ny, nx);
          }
        }
      }
      System.out.println(max);
  }
  
  static void swap(int i, int j, int ny, int nx){
    char tmp = board[ny][nx];
    board[ny][nx] = board[i][j];
    board[i][j] = tmp;
  }
  
  static int searchMaxLen(){
    int maxLen = 0;
    //행부터 탐색
    for(int i=0; i<n; i++){
      int cnt = 1;
      for(int j=1; j<n; j++){
        if(board[i][j-1] == board[i][j]) cnt++;
        else {
          maxLen = Math.max(maxLen, cnt);
          cnt = 1;
        }
      }
      maxLen = Math.max(maxLen, cnt);
    }
    
    
    //열 탐색
    for(int i=0; i<n; i++){
      int cnt = 1;
      for(int j=1; j<n; j++){
        if(board[j-1][i] == board[j][i]) cnt++;
        else{
          maxLen = Math.max(maxLen,cnt);
          cnt = 1;
        }
      }
      maxLen = Math.max(maxLen, cnt);
    }
    return maxLen;
  }
}