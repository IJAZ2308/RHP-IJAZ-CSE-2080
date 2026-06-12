import java.util.*;

public class Sushi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] A = new long[N];
        long[] B = new long[M];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        for (int i = 0; i < M; i++) {
            B[i] = sc.nextLong();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < N && j < M) {
            if (B[j] <= 2 * A[i]) {
                // Make sushi
                ans++;
                i++;
                j++;
            } else {
                // Shari is too small
                i++;
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
