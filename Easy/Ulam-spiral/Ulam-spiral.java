class Solution {

    public static void main(String args[]) {
        final int N = new java.util.Scanner(System.in).nextInt(), HALF = N / 2;
        char[][] spiral = new char[N][N];
        spiral[HALF][HALF] = ' ';
        for (int i = 1, num = 2; i <= N / 2; i++) {
            for (int j = HALF + i - 1; j > HALF - i; j--)
                spiral[j][HALF + i] = isPrime(num++) ? '#' : ' ';
            for (int j = HALF + i; j > HALF - i; j--)
                spiral[HALF - i][j] = isPrime(num++) ? '#' : ' ';
            for (int j = HALF - i; j < HALF + i; j++)
                spiral[j][HALF - i] = isPrime(num++) ? '#' : ' ';
            for (int j = HALF - i; j <= HALF + i; j++)
                spiral[HALF + i][j] = isPrime(num++) ? '#' : ' ';
        }
        for (int i = 0; i < N; System.out.println(), i++)
            for (int j = 0; j < N; j++)
                System.out.print(spiral[i][j] + (j != N - 1 ? " " : ""));
    }

    private static boolean isPrime(int num) {
        return new java.math.BigInteger(Integer.toString(num)).isProbablePrime(10);
    }
}
