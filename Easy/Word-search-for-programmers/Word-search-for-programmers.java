class Solution {

    private static final int[] dY = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dX = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int size = in.nextInt(); in.nextLine();
        char[][] grid = new char[size][size];
        boolean[][] stay = new boolean[size][size];
        // Read grid
        for (int i = 0; i < size; i++) {
            var ROW = in.nextLine().toCharArray();
            for (int j = 0; j < size; j++)
                grid[i][j] = ROW[j];
        }
        String[] clues = in.nextLine().toUpperCase().split(" ");
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                // Check all clues
                clue_loop: for (int wi = 0; wi < clues.length; wi++)
                    // Check at all angles, starting left to right and going clockwise
                    angle_loop: for (int di = 0; di < 8; di++) {
                        for (int ci = 0; ci < clues[wi].length(); ci++) {
                            char c;
                            try {
                                c = grid[i + dY[di] * ci][j + dX[di] * ci];
                            } catch (RuntimeException re) {
                                continue angle_loop;
                            }
                            if (c != clues[wi].charAt(ci))
                                if (ci == 0)
                                    continue clue_loop;
                                else
                                    continue angle_loop;
                        }
                        // Word found, update 'stay' matrix
                        for (int ci = 0; ci < clues[wi].length(); ci++)
                            stay[i + dY[di] * ci][j + dX[di] * ci] = true;
                    }
        // Print matrix
        for (int i = 0; i < size; System.out.println(), i++)
            for (int j = 0; j < size; j++)
                System.out.print(stay[i][j] ? grid[i][j] : ' ');
    }
}
