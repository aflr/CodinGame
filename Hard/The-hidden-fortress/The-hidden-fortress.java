class Solution {
    private static final String V = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int SIZE = in.nextInt(), grid[][] = new int[SIZE][SIZE],
                rowSum[] = new int[SIZE], colSum[] = new int[SIZE], N = 0;
        in.nextLine();
        for (int i = 0; i < SIZE; i++) {
            char[] ROW = in.nextLine().toCharArray();
            for (int j = 0; j < SIZE; j++) {
                int val = V.indexOf(ROW[j]);
                grid[i][j] = val; rowSum[i] += val; colSum[j] += val; N += val;
            }
        }
        N = N / (2 * SIZE - 1) * 2;
        for (int i = 0; i < SIZE; System.out.println(), i++)
            for (int j = 0; j < SIZE; j++)
                System.out.print(rowSum[i] + colSum[j] - N == grid[i][j] * (SIZE - 1) ? '.' : 'O');
    }
}
