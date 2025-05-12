import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int max = 1000001;
        boolean[] isNotPrime = new boolean[max + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i < max; i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j < max; j += i) {
                isNotPrime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < max; i++) {
            if (!isNotPrime[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
