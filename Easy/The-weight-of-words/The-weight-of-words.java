class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int steps = in.nextInt(), h = in.nextInt(), w = in.nextInt(); in.nextLine();
        char[][] grid = new char[h][];
        for (int i = 0; i < h; i++)
            grid[i] = in.nextLine().toCharArray();
        while (steps-- > 0) {
            for (int j = 0; j < w; j++) {
                int sum = 0;
                for (int i = 0; i < h; i++)
                    sum += grid[i][j];
                char[] col = new char[h];
                for (int i = 0; i < h; i++)
                    col[(i + sum) % h] = grid[i][j];
                for (int i = 0; i < h; i++)
                    grid[i][j] = col[i];
            }
            for (int i = 0; i < h; i++) {
                int sum = 0;
                for (int j = 0; j < w; j++)
                    sum += grid[i][j];
                char[] row = new char[w];
                for (int j = 0; j < w; j++)
                    row[(j + sum) % w] = grid[i][j];
                grid[i] = row;
            }
        }
        for (int i = 0; i < h; i++)
            System.out.println(String.valueOf(grid[i]));
    }
}
