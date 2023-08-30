import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(), H = in.nextInt();
        int T1 = in.nextInt(), T2 = in.nextInt(), T3 = in.nextInt();
        char[][] p1 = new char[H][W], p2 = new char[H][W], p3 = new char[H][W];
        for (char[] r : p3)
            Arrays.fill(r, '.');
        char maxChar = 'A';
        for (int i = 0; i < H; i++) {
            char[] p1r = in.next().toCharArray();
            char[] p2r = in.next().toCharArray();
            for (int j = 0; j < W; j++) {
                p1[i][j] = p1r[j];
                p2[i][j] = p2r[j];
                maxChar = (p1r[j] != '.' && maxChar < p1r[j]) ? p1r[j] : maxChar;
            }
        }

        // Solve
        for (char c = maxChar; c >= 'A'; c--) {
            int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
            search: for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (p1[i][j] == c) {
                        x1 = j;
                        y1 = i;
                    }
                    if (p2[i][j] == c) {
                        x2 = j;
                        y2 = i;
                    }
                    if (x1 != -1 && x2 != -1)
                        break search;
                }
            }
            if (x1 == -1 || x2 == -1)
                continue;
            int x3 = (int)Math.floor(x2 + (x2 - x1) * ((T3 - T2) / (double) (T2 - T1)));
            int y3 = (int)Math.floor(y2 + (y2 - y1) * ((T3 - T2) / (double) (T2 - T1)));
            System.err.println("Letter " + c + " at (" + x3 + "," + y3 + ")");
            if (x3 >= 0 && x3 < W && y3 >= 0 && y3 < H)
                p3[y3][x3] = c;
        }

        // Print solution
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++)
                System.out.print(p3[i][j]);
            System.out.println();
        }
    }
}
