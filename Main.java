1. Check Lowercase (a-z)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        if (ch >= 'a' && ch <= 'z')
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
2. Check Uppercase (A-Z)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        if (ch >= 'A' && ch <= 'Z')
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
3. Check Alphabet (a-z or A-Z)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
4. Check Digit (0-9)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        if (ch >= '0' && ch <= '9')
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
5. Check Alphanumeric (a-z, A-Z, 0-9)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);

        if ((ch >= 'a' && ch <= 'z') ||
            (ch >= 'A' && ch <= 'Z') ||
            (ch >= '0' && ch <= '9'))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
6. Check Entire String Contains Only a-z
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        boolean ok = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(ch >= 'a' && ch <= 'z')) {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? "Yes" : "No");
    }
}