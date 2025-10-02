import java.io.*;
import java.util.*; 

public class Main {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        
        for(int i=0; i<n; i++){
          nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        
        for(int i=n-1; i>-1; i--){
          //bw.write는 String값으로 출력함
          bw.write(String.valueOf(nums[i]));
          bw.write('\n');
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}