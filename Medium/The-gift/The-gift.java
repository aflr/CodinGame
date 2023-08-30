import java.util.*;

class Solution {
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        int n = in.nextInt(), p = in.nextInt(), sum = 0;
        int[] b = new int[n], c = new int[n];
        for (int i = 0; i < b.length; i++)
            sum += b[i] = in.nextInt();
        if (p > sum)
            System.out.println("IMPOSSIBLE");
        else {
            Arrays.sort(b);
            for (int i = 0; i < n; p -= c[i++])
                System.out.println(c[i] = Math.min(b[i], p / (n - i)));
        }
    }
}
