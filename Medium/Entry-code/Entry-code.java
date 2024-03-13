class Solution {
    private static int x, n, a[];
    private static java.util.List<Integer> seq;

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        x = in.nextInt(); n = in.nextInt();
        a = new int[x * n]; seq = new java.util.ArrayList<>();
        deBruijn(1, 1);
        System.out.println(seq.stream().map(i -> Integer.toString(i))
                .reduce(String::concat).get() + "0".repeat(n - 1));
    }

    private static void deBruijn(int t, int p) {
        if (t <= n) {
            a[t] = a[t - p];
            deBruijn(t + 1, p);
            for (int j = a[t - p] + 1; j < x; deBruijn(t + 1, t), j++)
                a[t] = j;
        } else if (n % p == 0)
            for (int i = 1; i < p + 1; i++)
                seq.add(a[i]);
    }
}
