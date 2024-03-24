import java.util.*;

/**
 * Compute how many points you scored with your new words !
 **/
class Solution {

    private static final Map<String, Integer[]> deltas = Map.of(
            "HORIZONTAL", new Integer[] { 0, 1 }, "VERTICAL", new Integer[] { 1, 0 });
    private static final Map<Character, Integer> tileValues = new HashMap<>();
    private static Tile[][] board;

    public static void main(String args[]) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int nbTiles = in.nextInt(); // Number of tiles in the tile set
        for (int i = 0; i < nbTiles; i++)
            tileValues.put(in.next().charAt(0), in.nextInt());
        int width = in.nextInt(), height = in.nextInt();
        if (in.hasNextLine())
            in.nextLine();
        board = new Tile[height][width];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = new Tile(i, j);
        for (int i = 0; i < height; i++) {
            char[] emptyBoardRow = in.nextLine().toCharArray(); // Empty board with special cells
            for (int j = 0; j < width; j++)
                board[i][j].special = emptyBoardRow[j];
        }
        for (int i = 0; i < height; i++) {
            char[] previousWordBoardRow = in.nextLine().toCharArray(); // Words already played
            for (int j = 0; j < width; j++)
                board[i][j].letterBefore = previousWordBoardRow[j];
        }
        List<Tile> newLetters = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            char[] playedWordBoardRow = in.nextLine().toCharArray(); // Words after you play
            for (int j = 0; j < width; j++) {
                board[i][j].letterAfter = playedWordBoardRow[j];
                if (board[i][j].justPlayed())
                    newLetters.add(board[i][j]);
            }
        }
        String DIR = "HORIZONTAL";
        if (newLetters.size() > 1 && newLetters.get(0).y != newLetters.get(1).y)
            DIR = "VERTICAL";
        List<List<Tile>> newWords = new ArrayList<>();

        {
            List<Tile> mainWord = new ArrayList<>();
            int s_y, s_x, e_y, e_x;
            s_y = e_y = newLetters.get(0).y;
            s_x = e_x = newLetters.get(0).x;
            mainWord.add(board[s_y][s_x]);
            while (board[s_y][s_x].letterAfter != '.') {
                s_y -= deltas.get(DIR)[0];
                s_x -= deltas.get(DIR)[1];
                if (s_y < 0 || s_x < 0 || board[s_y][s_x].letterAfter == '.')
                    break;
                mainWord.add(board[s_y][s_x]);
            }
            while (board[e_y][e_x].letterAfter != '.') {
                e_y += deltas.get(DIR)[0];
                e_x += deltas.get(DIR)[1];
                if (e_y >= height || e_x >= width || board[e_y][e_x].letterAfter == '.')
                    break;
                mainWord.add(board[e_y][e_x]);
            }
            if (mainWord.size() > 1) {
                mainWord.sort(null);
                newWords.add(mainWord);
            }
        }
        DIR = DIR.equals("HORIZONTAL") ? "VERTICAL" : "HORIZONTAL";
        Integer[] delta = deltas.get(DIR);
        for (Tile tile : newLetters) {
            List<Tile> word = new ArrayList<>();
            int s_y, s_x, e_y, e_x;
            s_y = e_y = tile.y;
            s_x = e_x = tile.x;
            word.add(board[s_y][s_x]);
            while (board[s_y][s_x].letterAfter != '.') {
                s_y -= delta[0];
                s_x -= delta[1];
                if (s_y < 0 || s_x < 0 || board[s_y][s_x].letterAfter == '.')
                    break;
                word.add(board[s_y][s_x]);
            }
            while (board[e_y][e_x].letterAfter != '.') {
                e_y += delta[0];
                e_x += delta[1];
                if (e_y >= height || e_x >= width || board[e_y][e_x].letterAfter == '.')
                    break;
                word.add(board[e_y][e_x]);
            }
            if (word.size() > 1) {
                word.sort(null);
                newWords.add(word);
            }
        }

        newWords.sort((l1, l2) -> {
            String s1 = l1.stream().map((t) -> t.toString()).reduce(String::concat).get();
            String s2 = l2.stream().map((t) -> t.toString()).reduce(String::concat).get();
            return s1.compareTo(s2);
        });
        int total = 0;
        for (List<Tile> tiles : newWords) {
            StringBuilder sb = new StringBuilder();
            int wordScore = 0;
            int[] wordMultipliers = new int[2];
            for (Tile t : tiles) {
                sb.append(t.letterAfter);
                int value = tileValues.getOrDefault(t.letterAfter, 0);
                wordScore += value;
                if (t.justPlayed())
                    switch (t.special) {
                        case 'l':
                            wordScore += value; break;
                        case 'L':
                            wordScore += 2 * value; break;
                        case 'w':
                            wordMultipliers[0]++; break;
                        case 'W':
                            wordMultipliers[1]++; break;
                    }
            }
            while (wordMultipliers[0]-- > 0)
                wordScore *= 2;
            while (wordMultipliers[1]-- > 0)
                wordScore *= 3;
            total += wordScore;
            System.out.println(sb.toString() + " " + wordScore);
        }
        if (newLetters.size() == 7) {
            total += 50;
            System.out.println("Bonus 50");
        }
        System.out.printf("Total %d\n", total);
    }

    private static class Tile implements Comparable<Object> {
        int y, x;
        char letterBefore, letterAfter, special;

        public Tile(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public boolean justPlayed() {
            return letterBefore != letterAfter;
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Tile))
                throw new ClassCastException();
            Tile other = (Tile) o;
            return (y != other.y) ? y - other.y : x - other.x;
        }

        @Override
        public String toString() {
            return Character.toString(letterAfter);
        }
    }
}
