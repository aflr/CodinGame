import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Solution {
    private static final boolean DEBUG = false;
    private static final String CHARS = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char[] LINES = { ' ', '-', '|', '+', '\\', '*', '*', '*', '/', '*', '*', '*', 'X', '*', '*', '*' };

    private static int H, W;
    private static Map<Integer, Position> dots;
    /*
     * The bits indicate, from right to left:
     * #0: 1 -> horizontal
     * #1: 2 -> vertical
     * #2: 4 -> main diagonal (up left to down right)
     * #3: 8 -> inv diagonal (up right to down left)
     */
    private static byte[][] grid;

    public static void main(String args[]) {
        readInput(new Scanner(System.in));
        processDots();
        printGrid(System.out);
    }

    private static void readInput(Scanner in) {
        H = in.nextInt();
        W = in.nextInt();
        in.nextLine();
        dots = new TreeMap<>();
        for (int i = 0; i < H; i++) {
            char[] row = in.nextLine().toCharArray();
            for (int j = 0; j < W; j++)
                if (row[j] != '.')
                    dots.put(CHARS.indexOf(row[j]), new Position(i, j));
        }
    }

    @SuppressWarnings("unchecked")
    private static void processDots() {
        grid = new byte[H][W];
        Object[] ds = dots.entrySet().toArray();
        for (int ii = 0; ii < ds.length - 1; ii++) {
            Position curr = new Position(((Map.Entry<Integer, Position>) ds[ii]).getValue());
            Position next = new Position(((Map.Entry<Integer, Position>) ds[ii + 1]).getValue());
            int[] delta = Position.getDelta(next, curr);
            int dir = Position.getDirectionFromDelta(delta);
            while (!curr.equals(next)) {
                if (DEBUG)
                    System.err.println("Dot #" + ii + " at (" + curr.y + "," + curr.x + "), dir " + LINES[dir]);
                grid[curr.y][curr.x] |= dir;
                curr.y += delta[0];
                curr.x += delta[1];
            }
        }
    }

    private static void printGrid(PrintStream ps) {
        StringBuilder sb;
        for (int i = 0; i < H; ps.println(sb.toString().stripTrailing()), i++) {
            sb = new StringBuilder();
            for (int j = 0; j < W; j++)
                sb.append(dots.containsValue(new Position(i, j)) ? 'o' : LINES[grid[i][j]]);
        }
    }

    private static class Position {

        public int y;
        public int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Position(Position o) {
            this.y = o.y;
            this.x = o.x;
        }

        public static int[] getDelta(Position p1, Position p2) {
            return new int[] { Integer.compare(p1.y, p2.y), Integer.compare(p1.x, p2.x) };
        }

        public static int getDirectionFromDelta(int[] delta) {
            if (delta[0] == 0)
                return 1 << 0;
            if (delta[1] == 0)
                return 1 << 1;
            if (delta[0] == delta[1])
                return 1 << 2;
            if (delta[0] == -delta[1])
                return 1 << 3;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Position))
                return false;
            Position other = (Position) o;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return 17 * y + 31 * x;
        }
    }
}
