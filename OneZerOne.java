import java.util.*;
class OneZerOne{
public static void main(String []args){
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
  while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            boolean hasOne = false;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if (a[i] == 1)
                    hasOne = true;
            }

            if (!hasOne) {
                a[0] = 1;
            } else {
                for (int i = 0; i < n; i++)
                    if (a[i] == -1)
                        a[i] = 0;
            }

            for (int x : a)
                System.out.print(x + " ");

            System.out.println();
        }
    }
}