class Solution {
    public static void main(String[]$) {
        var in = new java.util.Scanner(System.in);
        int w = in.nextInt(), h = in.nextInt();
        var b = new char[h][];
        for (int i = 0; i < h; i++)
            b[i] = in.next().toCharArray();
        for (int i = 0; i < h; System.out.println(), i++)
            for (int j = 0; j < w; j++)
                System.out.print(b[i][j] == '1' && (nc(b, i, j) < 2 || nc(b, i, j) > 3)
                        || b[i][j] == '0' && nc(b, i, j) != 3 ? '0' : '1');
    }

    static int nc(char[][] m, int y, int x) {
        int c = 0;
        for (int i = y - 1; i <= y + 1; i++)
            for (int j = x - 1; j <= x + 1; j++)
                try { c += (i != y || j != x) && m[i][j] == '1' ? 1 : 0;
                } catch (ArrayIndexOutOfBoundsException ex) {}
        return c;
    }
}
