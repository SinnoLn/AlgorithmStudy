import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long L = Long.parseLong(br.readLine().trim());

        long t = (L + 4) / 5;
        System.out.println(t);
    }
}
