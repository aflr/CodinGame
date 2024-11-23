class Solution {
    private static final int N = 4;
    private static char[][] grid = new char[N][];

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        for (int i = 0; i < N; i++)
            grid[i] = in.next().toCharArray();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) 
            System.out.println(validInGrid(in.next()));
    }

    private static boolean validInGrid(String word) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (grid[i][j] == word.charAt(0)) {
                    boolean[][] used = new boolean[N][N];
                    if (flood(word, i, j, used))
                        return true;
                }
        return false;
    }

    private static boolean flood(String w, int i, int j, boolean[][] u) {
        if (i < 0 || j < 0 || i >= N || j >= N || u[i][j] || grid[i][j] != w.charAt(0))
            return false;
        if (w.length() == 1)
            return true;
        u[i][j] = true;
        w = w.substring(1);
        return (flood(w, i - 1, j - 1, cloneMatrix(u))
                || flood(w, i - 1, j, cloneMatrix(u))
                || flood(w, i - 1, j + 1, cloneMatrix(u))
                || flood(w, i, j - 1, cloneMatrix(u))
                || flood(w, i, j + 1, cloneMatrix(u))
                || flood(w, i + 1, j - 1, cloneMatrix(u))
                || flood(w, i + 1, j, cloneMatrix(u))
                || flood(w, i + 1, j + 1, cloneMatrix(u)));
    }

    private static boolean[][] cloneMatrix(boolean[][] matrix) {
        boolean[][] newmatrix = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                newmatrix[i][j] = matrix[i][j];
        return newmatrix;
    }
}
