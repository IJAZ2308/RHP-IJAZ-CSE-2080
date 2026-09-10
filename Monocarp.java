import java.util.*;

class Monocarp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            int zeros = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == 0)
                    zeros++;
            }

            if (zeros < 2) {
                System.out.println(-1);
            } else {
                int ans = a[0] + a[n - 1];
                System.out.println(ans);
            }
        }

        sc.close();
    }
}