import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int[][] b = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                b[i][j] = in.nextInt();
        System.out.println(valid(b));
    }
    private static boolean valid(int[][] b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] < 1 || b[i][j] > 9)         // Check valid number
                    return false;
                for (int k = j + 1; k < 9; k++)         // Check row
                    if (b[i][j] == b[i][k]) return false;
                for (int k = i + 1; k < 9; k++)         // Check column
                    if (b[i][j] == b[k][j]) return false;
                for (int i0 = i / 3 * 3; i0 < i / 3 * 4; i0++)  // Check sub-grid
                    for (int j0 = j / 3 * 3; j0 < j / 3 * 4; j0++)
                        if ((i0 != i || j0 != j) && b[i][j] == b[i0][j0]) return false;
            }
        }
        return true;
    }
}
