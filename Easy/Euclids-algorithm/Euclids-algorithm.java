import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), ao = a;
        int b = in.nextInt(), bo = b;
        while (true) {
            if (b == 0) break;
            System.out.println(a + "=" + b + "*" + a / b + "+" + a % b);
            a %= b;
            if (a == 0) break;
            System.out.println(b + "=" + a + "*" + b / a + "+" + b % a);
            b %= a;
        }
        System.out.println("GCD(" + ao + "," + bo + ")=" + Math.max(a, b));
    }
}
