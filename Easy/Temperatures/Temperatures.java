import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if (i == 0)
                res = t;
            else if (Math.abs(t) <= Math.abs(res))
                res = t > 0 || res > 0 ? Math.min(Math.abs(t), Math.abs(res)) : t;
        }
        System.out.println(res);
    }
}
