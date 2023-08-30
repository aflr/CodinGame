class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int W = in.nextInt(); in.nextInt(); in.nextLine();
        var T = in.nextLine().split(" ");
        var black = true;
        for (int i = 0, c = 0; i < T.length; i++, black = !black) {
            int n = Integer.parseInt(T[i]);
            for (int j = 0; j < n; j++, c = (c + 1) % W)
                System.out.print((c == 0 ? "|" : "") + (black ? '*' : ' ') + (c == W - 1 ? "|\n" : ""));
        }
    }
}
