import java.util.*;

class StringPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qrTNum = sc.nextInt();

        while (qrTNum-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            if (s.charAt(0) == '0') {
                System.out.println(-1);
                continue;
            }

            if (s.contains("+-") || s.contains("-+")) {
                System.out.println(3);
                continue;
            }

            if (s.contains("+--+") || s.contains("-++-")) {
                System.out.println(3);
                continue;
            }

            boolean zeroOdd = false;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0' && (i + 1) % 2 == 1) {
                    zeroOdd = true;
                    break;
                }
            }

            if (zeroOdd)
                System.out.println(2);
            else
                System.out.println(1);
        }
    }
}