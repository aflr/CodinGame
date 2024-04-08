class Solution {

    private static final String ARROWS = "^>v<^";
    private static final java.util.Map<Character, Integer[]> DELTAS = java.util.Map.of(
            '>', new Integer[] { 0, +1 },
            'v', new Integer[] { +1, 0 },
            '<', new Integer[] { 0, -1 },
            '^', new Integer[] { -1, 0 });

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int W = in.nextInt(), H = in.nextInt(), Sx = in.nextInt(), Sy = in.nextInt(), rot = 0;
        int x = Sx, y = Sy;
        char[][] grid = new char[H][];
        for (int i = 0; i < H; i++)
            grid[i] = in.next().toCharArray();
        do {
            grid[y][x] = ARROWS.charAt(ARROWS.indexOf(grid[y][x]) + 1);
            Integer[] move = DELTAS.get(grid[y][x]);
            x += move[1];
            y += move[0];
            ++rot;
        } while (x >= 0 && y >= 0 && x < W && y < H && (x != Sx || y != Sy));
        System.out.println(rot);
    }
}
