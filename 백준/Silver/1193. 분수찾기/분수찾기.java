import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int line = 1;
        int sum = 0;

        // X가 속한 대각선 찾기
        while (sum + line < X) {
            sum += line;
            line++;
        }

        int pos = X - sum; // 현재 대각선에서 몇 번째인지

        int numerator, denominator;

        if (line % 2 == 0) {
            // 짝수 대각선: 위 -> 아래
            numerator = pos;
            denominator = line - pos + 1;
        } else {
            // 홀수 대각선: 아래 -> 위
            numerator = line - pos + 1;
            denominator = pos;
        }

        System.out.println(numerator + "/" + denominator);
    }
}