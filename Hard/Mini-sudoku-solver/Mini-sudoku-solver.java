import java.util.*;

class Solution {
    /*
     * Since the solution is unique, it is likely possible to avoid backtracking
     * and just... fill numbers until full
     */

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Read and store initial board state
        int[][] b = new int[4][4];
        char[] line1 = in.next().toCharArray();
        char[] line2 = in.next().toCharArray();
        char[] line3 = in.next().toCharArray();
        char[] line4 = in.next().toCharArray();
        for (int i = 0; i < 4; i++) {
            b[0][i] = line1[i] - '0';
            b[1][i] = line2[i] - '0';
            b[2][i] = line3[i] - '0';
            b[3][i] = line4[i] - '0';
        }

        // Create a matrix of lists of candidates
        List<Integer>[][] cands = new List[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cands[i][j] = new ArrayList<>(4);
                if (b[i][j] == 0) {
                    cands[i][j].add(1);
                    cands[i][j].add(2);
                    cands[i][j].add(3);
                    cands[i][j].add(4);
                }
            }
        }

        // Solve by removing candidates
        // and adding number if there's 1 possibility
        boolean doSmth = true;
        while (doSmth) {
            doSmth = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (b[i][j] != 0)
                        continue;
                    doSmth = true;
                    if (cands[i][j].size() == 1) {
                        b[i][j] = cands[i][j].get(0);
                    } else { // If a candidate is impossible, remove it from the list
                        List<Integer> li = cands[i][j];
                        Iterator<Integer> it = li.iterator();
                        while (it.hasNext()) {
                            int n = it.next();
                            if (impossible(b, j, i, n)) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        }

        // Print solved matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(b[i][j]);
            System.out.println();
        }
    }

    // Calculate if a number 'n' at x,y is impossible in a 4x4 board 'b'
    // Must check: row, column & 2x2 corner square
    private static boolean impossible(int[][] b, int x, int y, int n) {
        // Check row
        for (int i = 0; i < 4; i++) {
            if (i != x && b[y][i] == n)
                return true;
        }
        // Check column
        for (int i = 0; i < 4; i++) {
            if (i != y && b[i][x] == n)
                return true;
        }
        // Check 2x2 corner
        int x0 = x / 2 * 2;
        int y0 = y / 2 * 2;
        for (int i = y0; i < y0 + 2; i++) {
            for (int j = x0; j < x0 + 2; j++) {
                if ((i != y || j != x) && b[i][j] == n)
                    return true;
            }
        }
        return false;
    }
}
