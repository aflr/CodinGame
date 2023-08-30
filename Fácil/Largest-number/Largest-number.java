import java.util.*;

class Solution {

    private static boolean valid(char[] ns, int d) {
        int n = 0;
        for (int i = 0; i < ns.length; i++) {
            n *= 10;
            n += ns[i] - '0';
        }
        return (n % d == 0);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();

        // Try to remove 0 digits
        if (n % d == 0) {
            System.out.println(n);
            return;
        } else {
            // Try to remove 1 digit, start from the right, start at zero
            char[] ns = String.valueOf(n).toCharArray();
            for (int i = 0; i <= 9; i++) {
                for (int j = ns.length - 1; j >= 0; j--) {
                    if (ns[j] - '0' != i)
                        continue;
                    char[] newns = new char[ns.length - 1];
                    for (int k = 0, l = 0; k < newns.length; l++) {
                        if (l == j)
                            continue;
                        newns[k++] = ns[l];
                    }
                    if (valid(newns, d)) {
                        int print = Integer.parseInt(String.valueOf(newns));
                        System.out.println(print);
                        return;
                    }
                }
            }

            // Try to remove 2 digits, start from the right, start at zero
            for (int i = 0; i <= 9; i++) {
                for (int j = ns.length - 1; j >= 0; j--) {
                    if (ns[j] - '0' != i)
                        continue;
                    char[] newns = new char[ns.length - 1];
                    for (int k = 0, l = 0; k < newns.length; l++) {
                        if (l == j)
                            continue;
                        newns[k++] = ns[l];
                    }
                    // Remove another digit
                    for (int i2 = 0; i2 <= 9; i2++) {
                        for (int j2 = newns.length - 1; j2 >= 0; j2--) {
                            if (newns[j2] - '0' != i2)
                                continue;
                            char[] newns2 = new char[newns.length - 1];
                            for (int k2 = 0, l2 = 0; k2 < newns2.length; l2++) {
                                if (l2 == j2)
                                    continue;
                                newns2[k2++] = newns[l2];
                            }
                            if (valid(newns2, d)) {
                                int print = Integer.parseInt(String.valueOf(newns2));
                                System.out.println(print);
                                return;
                            }
                        }
                    }
                }
            }
        }
        // Not possible
        System.out.println(0);
    }
}
