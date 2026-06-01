import java.util.*;

public class Combination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int n = s.length();

        for (int mask = 1; mask < (1 << n); mask++) {
            StringBuilder combi = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    combi.append(s.charAt(i));
                }
            }

            System.out.println(combi);
        }
    }
}