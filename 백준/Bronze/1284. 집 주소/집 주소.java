import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String num = br.readLine();
            if(num.charAt(0) == '0') break;

            int ans = 2 + num.length()-1;
            for(int i=0; i<num.length(); i++){
                if(num.charAt(i) == '1') ans+=2;
                else if(num.charAt(i) == '0') ans+=4;
                else ans+=3;
            }
            System.out.println(ans);
        }
    }
}