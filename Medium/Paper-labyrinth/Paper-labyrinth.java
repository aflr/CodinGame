class Solution {

    private static int xs, ys, xr, yr;
    private static char[][] walls;

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        xs = in.nextInt(); ys = in.nextInt(); xr = in.nextInt(); yr = in.nextInt();
        int w = in.nextInt(), h = in.nextInt();
        walls = new char[h][w];
        int[][] mazeForth = new int[h][w], mazeBack = new int[h][w];
        for (int i = 0; i < h; i++) {
            walls[i] = in.next().toCharArray();
            for (int j = 0; j < w; j++)
                mazeForth[i][j] = mazeBack[i][j] = Integer.MAX_VALUE;
        }
        System.out.println(flood(0, mazeForth, xs, ys, true) + " " + flood(0, mazeBack, xr, yr, false));
    }

    private static int flood(int k, int[][] maze, int x, int y, boolean forth) {
        if (maze[y][x] <= k)
            return -1;
        maze[y][x] = k;
        int wall = Integer.parseInt(Character.toString(walls[y][x]), 16);
        if ((wall & 1) == 0)
            flood(k + 1, maze, x, y + 1, forth);
        if ((wall & 2) == 0)
            flood(k + 1, maze, x - 1, y, forth);
        if ((wall & 4) == 0)
            flood(k + 1, maze, x, y - 1, forth);
        if ((wall & 8) == 0)
            flood(k + 1, maze, x + 1, y, forth);
        return forth ? maze[yr][xr] : maze[ys][xs];
    }
}
