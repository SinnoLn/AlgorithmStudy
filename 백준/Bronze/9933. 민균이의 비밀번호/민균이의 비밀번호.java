import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String reversed = new StringBuilder(input).reverse().toString();

            if (set.contains(reversed) || input.equals(reversed)) {
                System.out.println(input.length() + " " + input.charAt(input.length() / 2));
                return;
            }

            set.add(input);
        }
    }
}