class Solution {
    static int h;
    static int w;
    static char[][] grid;

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        h = in.nextInt();
        w = in.nextInt();
        in.nextLine();
        grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            char[] line = in.nextLine().toCharArray();
            for (int j = 0; j < w; j++)
                grid[i][j] = line[j];
        }

        char[][] tmp;
        int turn = 0;
        boolean exit = false;
        while (!exit) {
            exit = true;
            tmp = new char[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] != '.') {
                        int newC;
                        switch (grid[i][j]) {
                            case '^':
                                newC = (i - 1 >= 0) ? i - 1: h - 1;
                                if (!isSquareInDangerMoreThanOnce(grid, newC, j))
                                    tmp[newC][j] = '^';
                                break;
                            case 'v':
                                newC = (i + 1) % h;
                                if (!isSquareInDangerMoreThanOnce(grid, newC, j))
                                    tmp[newC][j] = 'v';
                                break;
                            case '<':
                                newC = (j - 1 >= 0) ? j - 1 : w - 1;
                                if (!isSquareInDangerMoreThanOnce(grid, i, newC))
                                    tmp[i][newC] = '<';
                                break;
                            case '>':
                                newC = (j + 1) % w;
                                if (!isSquareInDangerMoreThanOnce(grid, i, newC))
                                    tmp[i][newC] = '>';
                                break;
                        }
                    }
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (tmp[i][j] != '\u0000') {
                        grid[i][j] = tmp[i][j];
                        exit = false;
                    } else {
                        grid[i][j] = '.';
                    }
                }
            }
            turn++;
        }
        System.out.println(turn);
    }

    private static boolean isSquareInDangerMoreThanOnce(char[][] grid, int i, int j) {
        int count = 0;
        try {
            if (grid[i - 1][j] == 'v')
                count++;
        } catch (ArrayIndexOutOfBoundsException ex) {
            if (grid[h - 1][j] == 'v')
                count++;
        }
        if (grid[(i + 1) % h][j] == '^')
            count++;

        try {
            if (grid[i][j - 1] == '>')
                count++;
        } catch (ArrayIndexOutOfBoundsException ex) {
            if (grid[i][w - 1] == '>')
                count++;
        }
        if (grid[i][(j + 1) % w] == '<')
            count++;
        return count > 1;
    }
}
