import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> ps = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            ps.add(in.nextInt());
        }
        ps.sort(null);
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            small = Math.min(small, Math.abs(ps.get(i) - ps.get(i + 1)));
        }
        System.out.println(small);
    }
}
