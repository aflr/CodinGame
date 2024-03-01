class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int L = in.nextInt(), N = in.nextInt(), M = 0;
        for (int i = 0, b; i < N; i++)
            M = Math.max(M, Math.max(b = in.nextInt(), L - b));
        System.out.println(M);
    }
}
