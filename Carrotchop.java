import java.util.*;

public class Carrotchop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] freq = new int[m + 1];

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                freq[x]++;
            }

            // suffix[i] = number of carrots with length >= i
            int[] suffix = new int[m + 2];

            for (int i = m; i >= 1; i--) {
                suffix[i] = suffix[i + 1] + freq[i];
            }

            int answer = 0;

            for (int y = 1; y <= m; y++) {

                // Number of carrots strictly greater than y
                int greater = suffix[y + 1];

                // Extra carrot when length = 2*y
                int extra = (2 * y <= m) ? freq[2 * y] : 0;

                int current = freq[y] + greater + extra;

                answer = Math.max(answer, current);
            }

            System.out.println(answer);
        }

        sc.close();
    }
}