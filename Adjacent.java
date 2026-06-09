import java.util.Scanner;

public class Adjacent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] mat = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int sum = 0;

                // Up
                if (i > 0)
                    sum += mat[i - 1][j];

                // Down
                if (i < R - 1)
                    sum += mat[i + 1][j];

                // Left
                if (j > 0)
                    sum += mat[i][j - 1];

                // Right
                if (j < C - 1)
                    sum += mat[i][j + 1];

                System.out.print(sum);

                if (j < C - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}