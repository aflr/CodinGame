class Solution {
    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int h = in.nextInt(), prevlen = -1; in.nextLine();
        int[][] grid = new int[h][];
        for (int i = 0, len = 0; i < h; i++) {
            String[] row = in.nextLine().split(" ");
            grid[i] = new int[row.length];
            for (int j = 0; j < row.length; j++)
                len += grid[i][j] = Integer.parseInt(row[j]);
            if (prevlen != -1 && prevlen != len) {
                System.out.println("INVALID");
                return;
            }
            prevlen = len;
            len = 0;
        }
        for (int i = 0; i < h; System.out.println(), i++) 
            for (int j = 0; j < grid[i].length; j++)
                for (int k = 0; k < grid[i][j]; k++)
                    System.out.print(j % 2 == 0 ? '.' : 'O');
    }
}
