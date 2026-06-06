import java.util.*;

public class column {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // rows
        int m = sc.nextInt(); // columns

        int[][] arr = new int[n][m];
        int[][] dp = new int[n][m];

        // Input matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Copy first column
        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
        }

        // Fill DP column by column
        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {

                int max = dp[i][j - 1]; // left

                if (i > 0)
                    max = Math.max(max, dp[i - 1][j - 1]); // left-up

                if (i < n - 1)
                    max = Math.max(max, dp[i + 1][j - 1]); // left-down

                dp[i][j] = arr[i][j] + max;
            }
        }

        // Print DP table
        System.out.println("DP Table:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // Find maximum in last column
        int ans = dp[0][m - 1];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, dp[i][m - 1]);
        }

        System.out.println("Maximum Path Sum = " + ans);
    }
}