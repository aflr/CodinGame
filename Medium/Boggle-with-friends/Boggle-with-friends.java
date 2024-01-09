import java.util.*;

class Solution {

    private static final int N = 4;
    private static char[][] grid;

    public static void main(String args[]) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);

        // Read grid
        grid = new char[N][];
        for (int i = 0; i < N; i++)
            grid[i] = in.nextLine().replaceAll(" ", "").toCharArray();

        // Read player's words
        Map<String, Integer> freq = new HashMap<>();
        List<Player> players = new ArrayList<>();
        int numOfFriendsPlaying = in.nextInt(); in.nextLine();
        for (int i = 0; i < numOfFriendsPlaying; i++) {
            String[] line = in.nextLine().split(" ");
            players.add(new Player(line[0]));

            // Record word frequencies, tentatively add words to players
            Set<String> unique = new HashSet<>();
            for (int j = 2; j < line.length; j++)
                if (validInGrid(line[j]) && unique.add(line[j])) {
                    freq.put(line[j], freq.getOrDefault(line[j], 0) + 1);
                    players.get(i).addScoringWord(line[j]);
                }
        }

        // Remove all words with frequency > 1 from all players
        freq.forEach((k, v) -> {if (v > 1) players.forEach(p -> p.removeWord(k));});

        // Print winner
        System.out.println(players
                .stream()
                .reduce((ac, cv) -> ac = ac.getScore() < cv.getScore() ? cv : ac)
                .get()
                .getName() + " is the winner!");

        // Print each player's score
        System.out.println("\n===Each Player's Score===");
        players.forEach(System.out::println);

        // Print each scoring player's scoring words
        System.out.println("\n===Each Scoring Player's Scoring Words===");
        players.forEach(Player::printScoringWords);
    }

	private static class Player {
        private String name;
        private int score;
        private List<String> scoringWords;

        public Player(String name) {
            this.name = name;
            score = 0;
            scoringWords = new ArrayList<>();
        }

        public boolean addScoringWord(String word) {
            score += wordValue(word);
            return scoringWords.add(word);
        }

        public void removeWord(String word) {
            if (scoringWords.remove(word))
                score -= wordValue(word);
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public void printScoringWords() {
            if (score == 0)
                return;
            System.out.println(name);
            scoringWords.forEach(w -> System.out.println(wordValue(w) + " " + w));
        }

        @Override
        public String toString() {
            return name + " " + score;
        }
    }

    private static boolean validInGrid(String word) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //TODO
            }
        }
		return false;
	}

    private static int wordValue(String word) {
            switch (word.length()) {
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                case 6:
                    return 3;
                case 7:
                    return 5;
                default:
                    return 11;
            }
    }
}
