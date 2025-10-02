import java.io.*;
import java.util.*; 

//자바 왜 30초임?
public class Main {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        int[] map = new int[n];
        for(int i=0; i<n; i++) map[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(map);
        
        for(int i=0; i<n; i++){
          bw.write(String.valueOf(map[i]));
          bw.write('\n');
        }
        
        bw.flush();
        bw.close();
        br.close();
        
    }
}