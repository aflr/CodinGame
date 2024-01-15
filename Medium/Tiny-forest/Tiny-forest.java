import java.util.*;

class Solution {
    private static char[][] land;
    private static int W, H;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt(); H = in.nextInt(); in.nextLine();
        // Read forest
        char [][] initialLand = new char[H][];
        land = new char[H][W];
        for (int i = 0; i < H; i++)
            initialLand[i] = in.nextLine().toCharArray();
        // Grow existing trees 33 years
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (initialLand[i][j] == 'Y')
                    grow(i, j, 3);
        // Find best increase in trees, while counting current trees
        int total = 0, maxinc = 0;
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++) {
                if (land[i][j] == 'Y')
                    total++;
                int inc = 0;
                for (int ii = i - 3; ii <= i + 3; ii++)
                    for (int jj = j - 3; jj <= j + 3; jj++)
                        if (ii >= 0 && jj >= 0 && ii < H && jj < W
                            && Math.abs(ii - i) + Math.abs(jj - j) < 3
                            && land[ii][jj] != 'Y')
                            inc++;
                maxinc = inc > maxinc ? inc : maxinc;
            }
        System.out.println(total + maxinc);
    }

    // Grow -> flood fill up to 'n' depth
    private static void grow(int i, int j, int n) {
        if (i < 0 || i > H - 1 || j < 0 || j > W - 1)
            return;
        land[i][j] = 'Y';
        if (n-- > 0) {
            grow(i - 1, j, n);
            grow(i + 1, j, n);
            grow(i, j - 1, n);
            grow(i, j + 1, n);
        }
    }
}
