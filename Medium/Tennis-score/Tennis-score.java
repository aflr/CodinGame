import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // Read data
        String[] names = in.nextLine().split(" ");
        int maxSets = in.nextInt();
        in.nextLine();
        String points = in.nextLine();

        // Make match, process points, then print match state and winner
        Match m = new Match(names, maxSets, parsePoints(points));
        m.processPoints();
        System.out.print(m);
        m.printWinner();
    }

    private static class Match {
        public String[] names;
        public int[] bin;

        public int winner;
        public Score score;

        public Match(String[] names, int maxSets, int[] bin) {
            this.names = names;
            this.bin = bin;

            winner = -1;
            score = new Score(maxSets);
        }

        public void processPoints() {
            for (int i = 0; i < bin.length; i++)
                if (!score.addPoint(bin[i]))
                    break;
            winner = score.winner;
        }

        public void printWinner() {
            switch (winner) {
                case -1:
                    System.out.println("Game in progress");
                    break;
                case 0:
                case 1:
                    System.out.println(names[winner] + " wins");
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(names[0]).append(".".repeat(15 - names[0].length()));
            sb.append(score.toString(0)).append('\n');
            sb.append(names[1]).append(".".repeat(15 - names[1].length()));
            sb.append(score.toString(1)).append('\n');
            return sb.toString();
        }
    }

    private static class Score {

        public int[][] sets;
        public int setIndex;
        public int[] game;
        boolean tiebreak;
        public int winner;

        public Score(int maxSets) {
            sets = new int[2][maxSets];
            setIndex = 0;
            game = new int[2];
            tiebreak = false;
            winner = -1;
        }

        // return: true -> match in progress, false -> game has ended
        public boolean addPoint(int pointWinner) {
            game[pointWinner]++;
            // Game won
            if (game[pointWinner] >= (tiebreak ? (setIndex != sets[0].length - 1 ? 7 : 10) : 4)
                    && game[pointWinner] >= game[1 - pointWinner] + 2) {
                sets[pointWinner][setIndex]++;
                game = new int[2];
                // Set won
                if (sets[pointWinner][setIndex] == 6
                        && sets[pointWinner][setIndex] >= sets[1 - pointWinner][setIndex] + 2
                        || sets[pointWinner][setIndex] == 7) {
                    tiebreak = false;
                    if (countSetWins(pointWinner) > sets[0].length / 2) {
                        winner = pointWinner;
                        return false;
                    }
                    setIndex++;
                }
                if (sets[0][setIndex] == 6 && sets[1][setIndex] == 6)
                    tiebreak = true;
            }
            return true;
        }

        private int countSetWins(int p) {
            int count = 0;
            for (int i = 0; i < sets[p].length; i++) {
                if (sets[p][i] > sets[1 - p][i])
                    count++;
            }
            return count;
        }

        public String toString(int p) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i <= Math.min(setIndex, sets[0].length - 1); i++) {
                sb.append(' ').append(sets[p][i]);
            }
            if (winner == -1) {
                sb.append(" | ");
                if (tiebreak)
                    sb.append(game[p]);
                else
                    switch (game[p]) {
                        case 0:
                            sb.append("0");
                            break;
                        case 1:
                            sb.append("15");
                            break;
                        case 2:
                            sb.append("30");
                            break;
                        case 3:
                            if (game[p] >= game[1 - p])
                                sb.append("40");
                            else
                                sb.append("-");
                            break;
                        default:
                            if (game[p] > game[1 - p])
                                sb.append("AV");
                            else if (game[p] < game[1 - p])
                                sb.append("-");
                            else
                                sb.append("40");
                            break;
                    }
            }
            return sb.toString();
        }
    }

    private static int[] parsePoints(String s) {
        // Split string
        // parse as hex
        // turn into binary string, pad with zeroes
        // turn into int array with values 0 or 1

        String[] points = s.split(" ");
        int[] hex = new int[points.length];
        for (int i = 0; i < hex.length; i++)
            hex[i] = Integer.parseInt(points[i], 16);
        StringBuilder sb = new StringBuilder();
        for (int h : hex) {
            String tmp = Integer.toBinaryString(h);
            sb.append("0".repeat(8 - tmp.length())).append(tmp);
        }
        char[] binChar = sb.toString().toCharArray();
        int[] bin = new int[binChar.length];
        for (int i = 0; i < bin.length; i++)
            bin[i] = binChar[i] - '0';
        return bin;
    }
}
