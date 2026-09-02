import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] a = new long[n];
        long[] b = new long[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        for (int i = 0; i < m; i++) {
            b[i] = sc.nextLong();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int j = 0;
        int count = 0;

        for (int i = 0; i < n && j < m; i++) {
            if (b[j] <= 2 * a[i]) {
                count++;
                j++;
            }
        }

        System.out.println(count);
    }
}
