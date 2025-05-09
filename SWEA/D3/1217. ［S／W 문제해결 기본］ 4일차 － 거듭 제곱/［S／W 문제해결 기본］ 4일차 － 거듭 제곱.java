import java.util.Scanner;

public class Solution {
   static int n,m;
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      for(int t=1; t<=10; t++){
        int test = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        
        int ans = getAns(n,0);
        System.out.println("#"+t+" "+ans);
      }
  }
  
  static int getAns(int n, int cnt){
    if(cnt == m) return 1;
    return n*getAns(n,cnt+1);
  }
}