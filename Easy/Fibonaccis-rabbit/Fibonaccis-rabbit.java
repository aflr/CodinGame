import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Long> F = new HashMap<>();
        F.put(0, (long) in.nextInt());
        int N = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        for (int i = 1; i <= N; i++) {
            long sum = 0;
            for (int j = a; j <= b; j++)
                sum += F.getOrDefault(i - j, 0L);
            F.put(i, sum);
        }
        System.out.println(F.get(N));
    }
}
