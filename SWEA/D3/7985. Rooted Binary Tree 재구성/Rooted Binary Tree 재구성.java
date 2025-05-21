import java.util.*;
import java.io.*;

public class Solution {
    static int[] order;
    static List<List<Integer>> depths;
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      for(int t=1; t<=test; t++){
        int k = Integer.parseInt(br.readLine());
        int n = (int)Math.pow(2,k)-1;
        order = new int[n];
        depths = new ArrayList<>();
        
        for (int i = 0; i < k; i++) {
          depths.add(new ArrayList<>());
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
          order[i] = Integer.parseInt(st.nextToken());
        }
        
        findTree(0,n-1,0);
        
        System.out.print("#"+t+" ");
        for(List<Integer> node : depths){
          StringBuilder sb = new StringBuilder();
          for(int i : node) sb.append(i).append(" ");
          System.out.println(sb.toString());
        }
      }
  }
  
  static void findTree(int left, int right, int depth){
    if(left>right) return;
    int mid = (left+right) / 2;
    depths.get(depth).add(order[mid]);
    
    findTree(left, mid-1, depth+1);
    findTree(mid+1, right, depth+1);
  }
}