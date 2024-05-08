class Solution {

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int H = in.nextInt(), W = in.nextInt(); in.nextLine();

        int[][] nums = new int[H][W];
        boolean[][] XS = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            String[] line = in.nextLine().split(" ");
            for (int j = 0; j < W; j++)
                nums[i][j] = Integer.parseInt(line[j]);
        }
        for (int i = 0; i < H; i++) {
            String[] line = in.nextLine().split(" ");
            for (int j = 0; j < W; j++)
                XS[i][j] = line[j].equals("X");
        }

        int prevSign = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (!XS[i][j])
                    continue;
                int sign = Integer.signum(nums[i][j]);
                if (prevSign == sign) {
                    System.out.println(false);
                    Runtime.getRuntime().exit(0);
                }
                prevSign = sign;
            }
        }
        System.out.println(true);
    }
}
