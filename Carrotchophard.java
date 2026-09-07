import java.util.*;

public class Carrotchophard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] a = new int[n];

            int maxA = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                maxA = Math.max(maxA, a[i]);
            }

            long power = 1;

            for (int k = 1; k <= m; k++) {

                // 2^k
                power = Math.min(power * 2, (long) maxA);

                // x = ceil(maxA / power)
                int x = (int) ((maxA + power - 1) / power);

                long answer = 0;

                for (int value : a) {
                    answer += value / x;
                }

                System.out.print(answer);

                if (k < m) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        sc.close();
    }
}