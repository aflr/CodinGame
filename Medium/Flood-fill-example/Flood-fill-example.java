import java.util.*;
import java.io.*;

class Solution {
    private static int H, W;
    private static char[][] map;
    private static List<Tower> towers;
    private static int[][][] towerMaps;

    public static void main(String args[]) {
        readInput(new Scanner(System.in));
        findTowers();
        processTowerMaps();
        printMap(System.out);
    }

    private static void readInput(Scanner in) {
        W = in.nextInt(); H = in.nextInt(); in.nextLine();
        map = new char[H][];
        for (int i = 0; i < H; i++)
            map[i] = in.nextLine().toCharArray();
    }

    private static void findTowers() {
        towers = new ArrayList<>();
        for (int i = 0, id = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (map[i][j] != '.' && map[i][j] != '#')
                    towers.add(new Tower(id++, map[i][j], i, j));
    }

    private static void processTowerMaps() {
        towerMaps = new int[towers.size()][H][W];
        for (var m : towerMaps)
            for (var r : m)
                Arrays.fill(r, Integer.MAX_VALUE);
        for (Tower t : towers)
            flood(towerMaps[t.uniqueId], t.y, t.x, 0);
    }

    private static void flood(int[][] m, int y, int x, int v) {
        if (y < 0 || x < 0 || y >= H || x >= W || m[y][x] <= v || v != 0 && map[y][x] != '.')
            return;
        m[y][x] = v++;
        flood(m, y - 1, x, v); flood(m, y + 1, x, v); flood(m, y, x - 1, v); flood(m, y, x + 1, v);
    }

    private static void printMap(PrintStream ps) {
        for (int i = 0; i < H; ps.println(), i++)
            for (int j = 0; j < W; j++) {
                int bestTowerId = -1, min = Integer.MAX_VALUE;
                boolean tied = false;
                for (int k = 0; k < towerMaps.length; k++) {
                    if (towerMaps[k][i][j] == min)
                        tied = true;
                    else if (towerMaps[k][i][j] < min) {
                        min = towerMaps[bestTowerId = k][i][j];
                        tied = false;
                    }
                }
                ps.print(bestTowerId < 0 ? map[i][j] : tied ? '+' : towers.get(bestTowerId).symbol);
            }
    }

    private static record Tower(int uniqueId, char symbol, int y, int x) { }
}
