import java.util.*;

class Player {

    private static int[][] map = new int[10][10];
    private static int py, px;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        for (int i = 0; i < 10; i++) {
            char[] s = in.nextLine().toCharArray();
            for (int j = 0; j < 10; j++) {
                if (s[j] == 'P') {
                    px = j;
                    py = i;
                }
                map[i][j] = s[j] == '*' ? -255 : 255;
            }
        }
        // game loop
        while (true) {
            int eneY = in.nextInt(), eneX = in.nextInt();
            int[][] copy = new int[10][10];
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    copy[i][j] = map[i][j];
            flood(0, copy, eneY, eneX);
            char d = 'U';
            int m = 255;
            if (py > 0 && Math.abs(copy[py - 1][px]) < m) {
                m = copy[py - 1][px];
                d = 'U';
            }
            if (py < 9 && Math.abs(copy[py + 1][px]) < m) {
                m = copy[py + 1][px];
                d = 'D';
            }
            if (px > 0 && Math.abs(copy[py][px - 1]) < m) {
                m = copy[py][px - 1];
                d = 'L';
            }
            if (px < 9 && Math.abs(copy[py][px + 1]) < m) {
                m = copy[py][px + 1];
                d = 'R';
            }
            switch (d) {
                case 'U': py--; break;
                case 'D': py++; break;
                case 'L': px--; break;
                case 'R': px++; break;
            }
            System.out.println(d);
        }
    }

    // Flood from enemy to player
    private static void flood(int k, int[][] copy, int y, int x) {
        if (x < 0 || y < 0 || x > 9 || y > 9 || copy[y][x] < k)
            return;
        copy[y][x] = k++;
        flood(k, copy, y - 1, x);
        flood(k, copy, y + 1, x);
        flood(k, copy, y, x - 1);
        flood(k, copy, y, x + 1);
    }
}
