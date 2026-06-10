import java.util.Scanner;

public class LongestCommonSubstring {

    // Helper class to return both the length and the text
    public static class Result {
        public final int length;
        public final String substring;

        public Result(int length, String substring) {
            this.length = length;
            this.substring = substring;
        }
    }

    public static Result findLCS(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return new Result(0, "");
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        int maxLen = 0;
        int endIndex = 0; 

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        String longestSub = s1.substring(endIndex - maxLen, endIndex);
        return new Result(maxLen, longestSub);
    }

    public static void main(String[] args) {
        // Create scanner to read console inputs
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String stringA = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String stringB = scanner.nextLine();

        // Close the scanner to prevent memory leaks
        scanner.close();

        // Process inputs
        Result result = findLCS(stringA, stringB);

        // Display outcomes
        System.out.println("\n--- Results ---");
        System.out.println("Length: " + result.length);
        System.out.println("Substring: \"" + result.substring + "\"");
    }
}
