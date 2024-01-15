import java.io.PrintStream;
import java.util.*;

class Solution {
    private static Map<Point, Character> grid = new TreeMap<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); in.nextLine();

        // Read lines into list of instructions
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(in.nextLine() + (i != n - 1 ? ";" : ""));
        List<String> ins = Arrays.asList(sb.toString().split("[\n;]"));

        // Create turtle with default parameters
        Turtle t = new Turtle(Direction.NORTH, '#', ' ', true);

        // Execute instructions
        ins.forEach(i -> t.exec(i.split(" ")));

        // Print grid
        t.printGrid(System.out);
    }

    private static class Point implements Comparable<Object> {
        public int y;
        public int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Object obj) {
            Point o = (Point) obj;
            if (y != o.y)
                return Integer.compare(y, o.y);
            return Integer.compare(x, o.x);
        }
    };

    private static class Turtle {
        private int y, x;
        private Direction dir;
        private char pc;
        private char bg;
        private boolean pd;

        public Turtle(Direction dir, char pc, char bg, boolean pd) {
            y = 0;
            x = 0;
            this.dir = dir;
            this.pc = pc;
            this.bg = bg;
            this.pd = pd;
        }

        public void exec(String[] ins) {
            switch (ins[0].toUpperCase()) {
                case "CS": // Clear screen
                    grid = new TreeMap<>();
                    bg = ins[1].charAt(0);
                    break;
                case "FD": // Forward (move)
                    int[] move = Direction.delta(dir);
                    int times = Integer.parseInt(ins[1]);
                    if (!pd) {
                        y += move[0] * times;
                        x += move[1] * times;
                    } else
                        for (int i = 0; i < times; i++) {
                            grid.put(new Point(y, x), pc);
                            y += move[0];
                            x += move[1];
                        }
                    break;
                case "RT": // Right turn
                    dir = Direction.RT(dir, Integer.parseInt(ins[1])); break;
                case "LT": // Left turn
                    dir = Direction.LT(dir, Integer.parseInt(ins[1])); break;
                case "PU": // Pen up
                    pd = false; break;
                case "PD": // Pen down
                    pd = true; break;
                case "SETPC": // Set character
                    pc = ins[1].charAt(0); break;
                default:
                    throw new IllegalArgumentException("Unknown command: " + ins[0]);
            }
        }

        @SuppressWarnings("unchecked")
        public void printGrid(PrintStream ps) {
            Set<Map.Entry<Point, Character>> set = grid.entrySet();

            // Calculate offsets so the logo is positioned
            // as close to the top left corner as possible
            y = Integer.MAX_VALUE;
            x = Integer.MAX_VALUE;
            Iterator<Map.Entry<Point, Character>> it = set.iterator();
            while (it.hasNext()) {
                Point p = it.next().getKey();
                y = Math.min(y, p.y);
                x = Math.min(x, p.x);
            }

            // Print all points
            final int offX = x;
            Object[] arr = set.toArray();
            for (int i = 0; i < arr.length; i++) {
                Point p = ((Map.Entry<Point, Character>)arr[i]).getKey();
                while (y < p.y) { // Move to correct row
                    ps.println();
                    x = offX;
                    y++;
                }
                while (x < p.x) { // Move to correct column
                    ps.print(bg);
                    x++;
                }
                // Print character
                ps.print(((Map.Entry<Point, Character>)arr[i]).getValue());
                x++;
            }
            ps.println();
        }
    }

    private enum Direction {
        NORTH, EAST, SOUTH, WEST;

        private static final List<Direction> AUX_DIRS = List.of(
                NORTH, EAST, SOUTH, WEST, NORTH, EAST, SOUTH);

        // Right turn
        public static Direction RT(Direction dir, int angle) {
            return AUX_DIRS.get(AUX_DIRS.indexOf(dir) + (angle % 360 / 90));
        }

        // Left turn
        public static Direction LT(Direction dir, int angle) {
            return AUX_DIRS.get(AUX_DIRS.lastIndexOf(dir) - (angle % 360 / 90));
        }

        // Changes to Y and X coordinates when moving in a direction
        public static final int[] delta(Direction dir) {
            switch (dir) {
                case NORTH: return new int[] { -1, 0 };
                case EAST:  return new int[] { 0, +1 };
                case SOUTH: return new int[] { +1, 0 };
                case WEST:  return new int[] { 0, -1 };
            }
            return null;
        }
    }
}
