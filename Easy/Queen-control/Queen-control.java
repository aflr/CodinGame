class Solution {
    private static final int N = 8;
    private static int Y, X;

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        boolean white = in.nextLine().equals("white");
        // Read and store board state
        char[][] b = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = in.nextLine().toCharArray();
            for (int j = 0; j < N; j++) {
                b[i][j] = line[j];
                if (b[i][j] == 'Q') {
                    X = j;
                    Y = i;
                }
            }
        }
        int count = 0;
        // Count row before queen
        for (int i = X - 1; i >= 0; i--) {
            if (sameColor(white, b[Y][i]))
                break;
            count++;
            if (b[Y][i] != '.')
                break;
        }
        // Count row after queen
        for (int i = X + 1; i < N; i++) {
            if (sameColor(white, b[Y][i]))
                break;
            count++;
            if (b[Y][i] != '.')
                break;
        }
        // Count col before queen
        for (int i = Y - 1; i >= 0; i--) {
            if (sameColor(white, b[i][X]))
                break;
            count++;
            if (b[i][X] != '.')
                break;
        }
        // Count col after queen
        for (int i = Y + 1; i < N; i++) {
            if (sameColor(white, b[i][X]))
                break;
            count++;
            if (b[i][X] != '.')
                break;
        }
        // Count main dia before queen
        for (int i = Y - 1, j = X - 1; i >= 0 && j >= 0; i--, j--) {
            if (sameColor(white, b[i][j]))
                break;
            count++;
            if (b[i][j] != '.')
                break;
        }
        // Count main dia after queen
        for (int i = Y + 1, j = X + 1; i < N && j < N; i++, j++) {
            if (sameColor(white, b[i][j]))
                break;
            count++;
            if (b[i][j] != '.')
                break;
        }
        // Count other dia before queen
        for (int i = Y + 1, j = X - 1; i < N && j >= 0; i++, j--) {
            if (sameColor(white, b[i][j]))
                break;
            count++;
            if (b[i][j] != '.')
                break;
        }
        // Count other dia after queen
        for (int i = Y - 1, j = X + 1; i >= 0 && j < N; i--, j++) {
            if (sameColor(white, b[i][j]))
                break;
            count++;
            if (b[i][j] != '.')
                break;
        }
        System.out.println(count);
    }

    private static boolean sameColor(boolean white, char c) {
        return ((white && c == 'w') || (!white && c == 'b'));
    }
}
