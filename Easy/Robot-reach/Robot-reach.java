import java.util.*;

class Solution {

    private static int R, C, T, count = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        R = in.nextInt(); C = in.nextInt(); T = in.nextInt();
        int[][] grid = new int[R][C];
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        flood(grid, 0, 0);
        for (var row : grid)
            count += Arrays.stream(row).filter(n -> n <= T).count();
        System.out.println(count);
    }

    private static void flood(int[][] g, int y, int x) {
        int sum;
        if (y < 0 || x < 0 || y >= R || x >= C
                || (sum = digitSum(y) + digitSum(x)) >= Math.min(g[y][x], T + 1))
            return;
        g[y][x] = sum;
        flood(g, y - 1, x);
        flood(g, y + 1, x);
        flood(g, y, x - 1);
        flood(g, y, x + 1);
    }

    private static int digitSum(int n) {
        return Integer.toString(n).chars().reduce(0, (a, d) -> a + Character.digit(d, 10));
    }
}
