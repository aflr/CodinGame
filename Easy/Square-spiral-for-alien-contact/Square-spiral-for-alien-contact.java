import java.util.*;

class Solution {

    static Map<String, Integer[]> MOVES = Map.of(
            "UP", new Integer[] { -1, 0 }, "DOWN", new Integer[] { +1, 0 },
            "LEFT", new Integer[] { 0, -1 }, "RIGHT", new Integer[] { 0, +1 });

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Read input
        String[] ins = in.nextLine().split(" ");

        int sideSize = Integer.parseInt(ins[0]);
        String start = ins[1];
        String rotationDirection = ins[2];
        char c = ins[3].charAt(0);
        int repeat = Integer.parseInt(ins[3].substring(1));
        int cInc = ins[4].charAt(0) - ins[3].charAt(0);
        int repInc = Integer.parseInt(ins[4].substring(1)) - Integer.parseInt(ins[3].substring(1));

        // Create spiral, fill with spaces
        char[][] squareSpiral = new char[sideSize][sideSize];
        for (int i = 0; i < sideSize; i++)
            for (int j = 0; j < sideSize; j++)
                squareSpiral[i][j] = ' ';

        int y = start.startsWith("top") ? 0 : sideSize - 1;
        int x = start.endsWith("Left") ? 0 : sideSize - 1;

        String moving = moveAtStart(rotationDirection, y, x);
        Integer[] delta = MOVES.get(moving);
        int rep = repeat;
        while (true) {
            // Write character in spiral
            squareSpiral[y][x] = c;
            // Update character to write next
            if (--rep == 0) {
                c += cInc;
                // If no letters left in alphabet, exit
                if (!Character.isUpperCase(c))
                    break;
                rep = repeat += repInc;
                // If repetitions have decreased to 0, exit
                if (rep == 0)
                    break;
            }
            // Calculate position to move to next
            int nextY = y + delta[0];
            int nextX = x + delta[1];
            // If next position out of bounds, turn in the given rotation
            if (nextY < 0 || nextX < 0 || nextY >= sideSize || nextX >= sideSize) {
                moving = rotationDirection.equals("clockwise") ? turnCW(moving) : turnCCW(moving);
                delta = MOVES.get(moving);
                nextY = y + delta[0];
                nextX = x + delta[1];
            }
            // Calculate 2 positions forward
            int fw2Y = y + 2 * delta[0];
            int fw2X = x + 2 * delta[1];
            // If the position 2 forward is valid but there is already a character, turn in the given rotation
            if (fw2Y >= 0 && fw2X >= 0 && fw2Y < sideSize && fw2X < sideSize && squareSpiral[fw2Y][fw2X] != ' ') {
                moving = rotationDirection.equals("clockwise") ? turnCW(moving) : turnCCW(moving);
                delta = MOVES.get(moving);
                nextY = y + delta[0];
                nextX = x + delta[1];
                fw2Y = y + 2 * delta[0];
                fw2X = x + 2 * delta[1];
                // If we would need to turn twice, exit
                if (fw2Y >= 0 && fw2X >= 0 && fw2Y < sideSize && fw2X < sideSize && squareSpiral[fw2Y][fw2X] != ' ')
                    break;
            }
            // Update position to write next
            y = nextY;
            x = nextX;
        }

        // Print spiral, max 31
        sideSize = Math.min(sideSize, 31);
        for (int i = 0; i < sideSize; System.out.println(), i++)
            for (int j = 0; j < sideSize; j++)
                System.out.print(squareSpiral[i][j]);
    }

    // Given a rotation (cw / ccw) and a corner [y, x], where to move
    private static String moveAtStart(String dir, int y, int x) {
        if (y == 0 && x == 0)
            return dir.equals("clockwise") ? "RIGHT" : "DOWN";
        if (y != 0 && x != 0)
            return dir.equals("clockwise") ? "LEFT" : "UP";
        if (y == 0 && x != 0)
            return dir.equals("clockwise") ? "DOWN" : "LEFT";
        if (y != 0 && x == 0)
            return dir.equals("clockwise") ? "UP" : "RIGHT";
        return null;
    }

    // Turn clockwise
    private static String turnCW(String dir) {
        switch (dir) {
            case "UP":
                return "RIGHT";
            case "DOWN":
                return "LEFT";
            case "LEFT":
                return "UP";
            case "RIGHT":
                return "DOWN";
            default:
                return null;
        }
    }

    // Turn counter-clockwise
    private static String turnCCW(String dir) {
        switch (dir) {
            case "UP":
                return "LEFT";
            case "DOWN":
                return "RIGHT";
            case "LEFT":
                return "DOWN";
            case "RIGHT":
                return "UP";
            default:
                return null;
        }
    }
}
