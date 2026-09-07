import java.util.*;

public class OddErase {

    static int hcf(int a, int b) {
        return b == 0 ? a : hcf(b, a % b);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(hcf(numbers[0], numbers[n - 1]));

        sc.close();
    }
}