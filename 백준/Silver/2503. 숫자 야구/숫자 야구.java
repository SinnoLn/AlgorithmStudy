import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String[]> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            questions.add(new String[]{s, String.valueOf(strike), String.valueOf(ball)});
        }
        
        int ans = 0;

        for(int num = 111; num <1000; num++){
            String currNum = Integer.toString(num);
            if(currNum.contains("0") || hasDuplicate(currNum))continue;

            boolean isPossible = true;
            for (String[] query : questions) {
                String s = query[0];
                int strike = Integer.parseInt(query[1]);
                int ball = Integer.parseInt(query[2]);

                if (!Check_num(currNum, s, strike, ball)) {
                    isPossible = false;
                    break;
                }
            }
             if (isPossible) ans++;
        }
        System.out.println(ans);
    }
    
    public static boolean Check_num(String currNum, String num, int s, int b){
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            if (currNum.charAt(i) == num.charAt(i)) {
                strike++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && currNum.charAt(i) == num.charAt(j)) {
                    ball++;
                }
            }
        }
        return (strike == s && ball == b);
    }

    public static boolean hasDuplicate(String num) {
        return num.charAt(0) == num.charAt(1) || num.charAt(1) == num.charAt(2) || num.charAt(0) == num.charAt(2);
    }
}