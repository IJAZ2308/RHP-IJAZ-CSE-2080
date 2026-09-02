import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i < r; i++) {

            int max = arr[i - 1][0];
            for (int j = 1; j < c; j++) {
                max = Math.max(max, arr[i - 1][j]);
            }

            for (int j = 0; j < c; j++) {
                arr[i][j] += max;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}