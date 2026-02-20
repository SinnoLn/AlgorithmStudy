import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, int[]> map = new HashMap<>();
        int index = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(i==3 && j==3) break;
                char c = (char)(index+65);
                map.put(c,new int[]{i,j});
                index++;
            } 
        }

        int sum = 0;
        for(int i=0; i<4; i++){
            String input = br.readLine();
            for(int j=0; j<4; j++){
                char c = input.charAt(j);
                if(c=='.') continue;
                int[] tmp = map.get(c);
                sum+=Math.abs(i-tmp[0])+ Math.abs(j-tmp[1]);
            }
        }
        System.out.println(sum);
    }
}