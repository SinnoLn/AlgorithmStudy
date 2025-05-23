import java.util.*;
import java.io.*;

public class Solution {
    static int max;
    static Set<String> set;  
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String num = st.nextToken();
        int swapCnt = Integer.parseInt(st.nextToken());
        
        max = 0;
        set = new HashSet<>();
        
        dfs(num,0,swapCnt);
        System.out.println("#"+t+" "+max);
      }
  }
  
  //백트랙킹
  //약 12만 번
  //가지치기
  static void dfs(String num, int currCnt, int swapCnt){
    String state = num+','+Integer.toString(currCnt);
    if(set.contains(state)) return;
    
    set.add(state);
    if(currCnt == swapCnt){
      max = Math.max(max, Integer.parseInt(num));
      return;
    }
    
    int len = num.length();
    char numList[] = num.toCharArray();
    for(int i=0; i<len-1; i++){
      for(int j=i+1; j<len; j++){
        swap(numList, i,j);
        dfs(new String(numList), currCnt+1, swapCnt);
        swap(numList, i,j);
      }
    }
  }
  
  static void swap(char arr[], int i, int j){
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}