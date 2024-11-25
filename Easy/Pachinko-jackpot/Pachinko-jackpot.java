import java.util.*;

class Solution {
    private static int H, prizes[], board[][];

    public static void main(String args[]) {
        readInput(new Scanner(System.in));
        for (int i = 1; i < H; i++) {
            board[i][0] += board[i - 1][0];
            board[i][i] += board[i - 1][i - 1];
            for (int j = 1; j < i; j++)
                board[i][j] += Math.max(board[i - 1][j - 1], board[i - 1][j]);
        }
        prizes[0] *= board[H - 1][0];
        prizes[H] *= board[H - 1][H - 1];
        for (int i = 1; i < H; i++)
            prizes[i] *= Math.max(board[H - 1][i - 1], board[H - 1][i]);
        System.out.println(Arrays.stream(prizes).max().getAsInt());
    }

    private static void readInput(Scanner in) {
        H = in.nextInt(); in.nextLine();
        board = new int[H][];
        for (int i = 0; i < H; i++)
            board[i] = in.nextLine().chars()
                    .map(ch -> Character.digit(ch, 10)).toArray();
        prizes = new int[H + 1];
        for (int i = 0; i < H + 1; i++)
            prizes[i] = in.nextInt();
    }
}
