import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt(), h = in.nextInt();
        char[][] grid = new char[h][];
        for (int i = 0; i < h; i++)
            grid[i] = in.next().toCharArray();
        for (int i = 0; i < h; System.out.println(), i++)
            for (int j = 0; j < w; j++)
                System.out.print(grid[i][j] != '#' ? adjacents(grid, i, j) : '#');
    }

    private static char adjacents(char[][] grid, int y, int x) {
        int count = 0;
        try{
            count += grid[y - 1][x] != '#' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException ex) {}
        try{
            count += grid[y + 1][x] != '#' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException ex) {}
        try{
            count += grid[y][x - 1] != '#' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException ex) {}
        try{
            count += grid[y][x + 1] != '#' ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException ex) {}
        return (char) (count + '0');
    }
}
