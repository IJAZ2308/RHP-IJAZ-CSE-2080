import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int k = fs.nextInt();
        int q = fs.nextInt();

        int MAX = 200000;

        int[] diff = new int[MAX + 3];

        for (int i = 0; i < n; i++) {
            int l = fs.nextInt();
            int r = fs.nextInt();

            diff[l]++;
            diff[r + 1]--;
        }

        int[] pref = new int[MAX + 2];
        int count = 0;

        for (int i = 1; i <= MAX; i++) {
            count += diff[i];

            if (count >= k) {
                pref[i] = 1;
            }
        }

        // prefix sum of admissible temperatures
        for (int i = 1; i <= MAX; i++) {
            pref[i] += pref[i - 1];
        }

        StringBuilder ans = new StringBuilder();

        while (q-- > 0) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            ans.append(pref[b] - pref[a - 1]).append('\n');
        }

        System.out.print(ans);
    }
}
