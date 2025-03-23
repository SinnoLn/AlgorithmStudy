import java.util.*;
import java.io.*;

class Main {
    public static boolean[] used = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String result = insertShortcut(line);
            System.out.println(result);
        }
    }

    public static String insertShortcut(String line) {
        String[] tokens = line.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            char c = Character.toUpperCase(tokens[i].charAt(0));
            int idx = c - 'A';
            if (!used[idx]) {
                used[idx] = true;
                tokens[i] = "[" + tokens[i].charAt(0) + "]" + tokens[i].substring(1);
                return String.join(" ", tokens);
            }
        }

        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < tokens[i].length(); j++) {
                char c = Character.toUpperCase(tokens[i].charAt(j));
                int idx = c - 'A';
                if (!used[idx]) {
                    used[idx] = true;
                    tokens[i] = tokens[i].substring(0, j) + "[" + tokens[i].charAt(j) + "]" + tokens[i].substring(j + 1);
                    return String.join(" ", tokens);
                }
            }
        }
        return line;
    }
}