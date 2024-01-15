import java.util.*;
import java.util.List;
import java.awt.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Number of snails

        // Parse and store snail speeds
        Map<Integer, Integer> speeds = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int speedSnail = in.nextInt();
            System.err.println(i + ": " + speedSnail);
            speeds.put(i, speedSnail);
        }

        int mapH = in.nextInt();
        int mapW = in.nextInt();
        
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // Parse and store snail positions and destination positions
        // Assume everything else is '*'
        Map<Integer, Point> snailPos = new HashMap<>(n);
        List<Point> destPos = new ArrayList<>();
        for (int i = 0; i < mapH; i++) {
            String ROW = in.nextLine();
            System.err.println(ROW);
            char[] chars = ROW.toCharArray();
            for (int j = 0; j < mapW; j++) {
                if (chars[j] == '#')
                    destPos.add(new Point(j, i));
                else if (chars[j] != '*')
                    snailPos.put(chars[j] - '0', new Point(j, i));
            }
        }

        // Calculate winner
        // Assume snails can fit into the same spot
        // Assume snails can never tie for 1st place
        int winner = -1;
        int dist = 15;
        for (Map.Entry<Integer, Point> entry : snailPos.entrySet()) {
            for (Point destination : destPos) {
                
                int steps = (int)Math.ceil((double)(Math.abs(entry.getValue().x - destination.x)
                        + Math.abs(entry.getValue().y - destination.y)) / speeds.get(entry.getKey()));
                if (steps < dist) {
                    dist = steps;
                    winner = entry.getKey();
                }
            }
        }
        System.out.println(winner);
    }
}
