import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        String[] dial = {"-1", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "0"};
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        int ans = 0;
        for(int i=0; i<num.length(); i++){
            char n = num.charAt(i);

            for(int j=0; j<dial.length; j++){
                if(dial[j].contains(String.valueOf(n))) {
                    ans+=(j+1);
                    break;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}