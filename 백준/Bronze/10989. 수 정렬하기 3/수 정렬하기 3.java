import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      
      int[] arr = new int[10001];
      for(int i=0; i<n; i++) {
        int num = Integer.parseInt(br.readLine());
        arr[num]++;
      }
      
      for(int i=1; i<10001; i++){
        if(arr[i] == 0) continue;
        for(int j=0; j<arr[i]; j++) bw.write(i+ "\n");
      }
      
      bw.flush();
      bw.close();
      br.close();
  }
}