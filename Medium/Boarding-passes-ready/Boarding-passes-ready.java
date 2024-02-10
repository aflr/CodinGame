import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt(), w = in.nextInt(), n = in.nextInt(); in.nextLine();
        String[][] seats = new String[h][w];
        for (int i = 0; i < n; i++) {
            String[] p = in.nextLine().split(",");
            seats[Integer.parseInt(p[1].substring(0, p[1].length() - 1)) - 1]
                    [p[1].charAt(p[1].length() - 1) - 'A'] = p[0];
        }
        for (int g = 1, z = 0; z < 2; g++) {
            List<String> board = new ArrayList<>();
            if (g % 2 == 1)
                for (int i = h - 1; i >= 0; i--)
                    for (int j = 0; j < w / 2; j++) {
                        if (seats[i][j] != null) {
                            board.add(seats[i][j]);
                            seats[i][j] = null;
                            break;
                        }
                    }
            else
                for (int i = h - 1; i >= 0; i--)
                    for (int j = w - 1; j >= w / 2; j--)
                        if (seats[i][j] != null) {
                            board.add(seats[i][j]);
                            seats[i][j] = null;
                            break;
                        }
            if (board.size() == 0)
                z++;
            else
                System.out.println("Now boarding: "
                        + board.stream().reduce((s1, s2) -> s1 + "," + s2).get());
        }
    }
}
