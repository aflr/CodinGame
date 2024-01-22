class Solution {

    private static int H, W;
    private static char[][] grid;

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        // Read grid
        H = in.nextInt(); W = in.nextInt(); in.nextLine();
        grid = new char[H][W];
        for (int i = 0; i < H; i++) {
            char[] row = in.nextLine().toCharArray();
            for (int j = 0; j < W; j++)
                grid[i][j] = row[j * 2];
        }
        // Flood fill from rightmost column
        for (int i = 0; i < H; i++)
            flood(i, W - 1);
        // Count characters in leftmost column
        int count = 0;
        for (int i = 0; i < H; i++)
            if (grid[i][0] == '&')
                count++;
        System.out.println(count);
    }

    private static void flood(int y, int x) {
        if (y < 0 || y >= H || x < 0 || x >= W || grid[y][x] != '+')
            return;
        grid[y][x] = '&';
        flood(y - 1, x);
        flood(y + 1, x);
        flood(y, x - 1);
        flood(y, x + 1);
    }
}
