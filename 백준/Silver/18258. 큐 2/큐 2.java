import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if(op.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
            }
            else if(op.equals("pop")) {
                sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
            }
            else if(op.equals("size")) {
                sb.append(queue.size()).append('\n');
            }
            else if(op.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            }
            else if(op.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
            }
            else if(op.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append('\n');
            }
        }

        System.out.print(sb);
    }
}
