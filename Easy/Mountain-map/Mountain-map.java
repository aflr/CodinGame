import static java.util.Arrays.stream;

class Solution {
    public static void main(String[]$) {
        var in = new java.util.Scanner(System.in);
        int n = in.nextInt(), hs[] = new int[n];
        for (int i = 0; i < n; hs[i++] = in.nextInt());
        var g = new char[stream(hs).max().getAsInt()][stream(hs).sum() * 2];
        stream(g).forEach(r -> java.util.Arrays.fill(r, ' '));
        for (int e = 0, sum = 0; e < n; sum += hs[e++])
            for (int i = g.length - hs[e], j = 0; i < g.length; i++, j++) {
                g[i][sum * 2 + hs[e] - j - 1] = '/';
                g[i][sum * 2 + hs[e] + j] = '\\';
            }
        stream(g).forEach(r -> System.out.println(String.valueOf(r).stripTrailing()));
    }
}
