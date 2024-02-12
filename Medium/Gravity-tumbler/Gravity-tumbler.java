class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int w = in.nextInt(), r[] = new int[in.nextInt()], t = in.nextInt(); in.nextLine();
        for (int i = 0; i < r.length; i++)
            r[i] = (int)in.nextLine().chars().filter(c -> c == '#').count();
        if (t % 2 == 0)
            for (int n : r)
                System.out.println(".".repeat(w - n) + "#".repeat(n));
        else
            for (int i = 0; i < w; i++) {
                final int I = i, n = (int)java.util.Arrays.stream(r).filter(v -> v >= w - I).count();
                System.out.println(".".repeat(r.length - n) + "#".repeat(n));
            }
    }
}
