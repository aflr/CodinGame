class Solution {
    // (dY, dX) order: north, east, south, west
    private static final int[][] D = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };

    private static int h, w;
    private static char[][] field;

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        h = in.nextInt(); w = in.nextInt(); in.nextLine();
        field = new char[h][];
        for (int i = 0; i < h; i++)
            field[i] = in.nextLine().toCharArray();
        int dir = 1, y = 0, x = -1;
        while (true) {
            int steps = 0;
            while (validPos(y + D[dir][0], x + D[dir][1])) {
                y += D[dir][0];
                x += D[dir][1];
                steps++;
            }
            System.out.print(steps);
            // Try to turn right
            int rightDir = (dir + 1) % 4;
            if (validPos(y + D[rightDir][0], x + D[rightDir][1])) {
                dir = rightDir;
                System.out.print('R');
                continue;
            }
            // Try to turn left
            int leftDir = (dir + 3) % 4;
            if (validPos(y + D[leftDir][0], x + D[leftDir][1])) {
                dir = leftDir;
                System.out.print('L');
                continue;
            }
            break;
        }
        System.out.println();
    }

    public static boolean validPos(int y, int x) {
        return y >= 0 && x >= 0 && y < h && x < w && field[y][x] == '#';
    }
}
