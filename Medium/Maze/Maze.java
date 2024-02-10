import java.util.*;

class Solution {
    private static final char VISITED = '*';

    private static int W, H;
    private static char[][] maze;
    private static List<Point> exits;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        W = in.nextInt(); H = in.nextInt();
        int X = in.nextInt(), Y = in.nextInt();
        in.nextLine();
        maze = new char[H][W];
        for (int i = 0; i < H; i++) {
            char[] row = in.nextLine().toCharArray();
            for (int j = 0; j < W; j++)
                maze[i][j] = row[j];
        }
        exits = new ArrayList<>();
        flood(X, Y);
        findExits();
        System.out.println(exits.size());
        exits.sort(null);
        exits.forEach(System.out::println);
    }

    private static void flood(int x, int y) {
        if (x < 0 || y < 0 || x >= W || y >= H || maze[y][x] != '.')
            return;
        maze[y][x] = VISITED;
        flood(x - 1, y);
        flood(x + 1, y);
        flood(x, y - 1);
        flood(x, y + 1);
    }

    private static void findExits() {
        for (int i = 0; i < H; i++) {
            if (maze[i][0] == VISITED)
                exits.add(new Point(0, i));
            if (maze[i][W - 1] == VISITED)
                exits.add(new Point(W - 1, i));
        }
        for (int j = 1; j < W - 1; j++) {
            if (maze[0][j] == VISITED)
                exits.add(new Point(j, 0));
            if (maze[H - 1][j] == VISITED)
                exits.add(new Point(j, H - 1));
        }
    }

    private record Point (int x, int y) implements Comparable<Object> {
		@Override
		public int compareTo(Object o) {
            Point op = (Point) o;
			if (x != op.x)
                return x - op.x;
            return y - op.y;
		}

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
