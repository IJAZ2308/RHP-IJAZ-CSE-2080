import java.util.*;

class MinusTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++)
                array[i] = sc.nextInt();

            int odd = 0, r0 = 0, r2 = 0;

            for (int x : array) {
                if (x % 2 == 1)
                    odd++;
                else if (x % 4 == 0)
                    r0++;
                else
                    r2++;
            }

            System.out.println(Math.max(odd, Math.max(r0, r2)));
        }

        sc.close();
    }
}