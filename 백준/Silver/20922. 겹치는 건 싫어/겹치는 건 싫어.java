import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int[] arr = new int[n];
      Map<Integer, Integer> checkDupli = new HashMap<>();

      for(int i=0; i<n; i++){
        arr[i] = Integer.parseInt(st.nextToken());
        checkDupli.put(arr[i], 0);
      }

      //로직 시작
      int maxLen = 0;
      int currLen = 0;

      int l = 0;
      int r = 0;

      while(r < n) {

        int cnt = checkDupli.get(arr[r]);
        checkDupli.put(arr[r], cnt + 1);
        currLen++;

        // 초과하면 해소될 때까지 l 이동
        while(checkDupli.get(arr[r]) > k) {
          int leftCnt = checkDupli.get(arr[l]);
          checkDupli.put(arr[l], leftCnt - 1);
          l++;
          currLen--;
        }

        maxLen = Math.max(maxLen, currLen);
        r++;
      }

      System.out.println(maxLen);
    }
}