import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> line = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
          line.add(Integer.parseInt(st.nextToken()));
        } 
        Deque<Integer> side = new ArrayDeque<>();
        int need = 1;

        while (!line.isEmpty()) {
            if (!line.isEmpty() && line.peek() == need) {
                line.poll();
                need++;
                continue;
            }
            if (!side.isEmpty() && side.peekLast() == need) {
                side.pollLast();
                need++;
                continue;
            }
            side.addLast(line.poll());
        }

        while (!side.isEmpty() && side.peekLast() == need) {
            side.pollLast();
            need++;
        }
        System.out.println(need == n + 1 ? "Nice" : "Sad");
    }
}
