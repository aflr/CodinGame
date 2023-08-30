class Solution {
    private enum RPS {
        Rock, Paper, Scissors;

        // Loss -> -1, Draw -> 0, Win -> 1
        int fight(RPS other) {
            if (other == Rock && this == Scissors
                    || other == Paper && this == Rock
                    || other == Scissors && this == Paper)
                return -1;
            if (this == Rock && other == Scissors
                    || this == Paper && other == Rock
                    || this == Scissors && other == Paper)
                return 1;
            return 0;
        }

        static RPS parse(String s) {
            switch (s) {
                case "Rock": return Rock;
                case "Paper": return Paper;
                case "Scissors": return Scissors;
            }
            return null;
        }
    }

    public static void main(String args[]) {
        var in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        // Read opponents
        RPS[] p = new RPS[n];
        for (int i = 0; i < n; i++)
            p[i] = RPS.parse(in.nextLine());

        // Try all combinations of move + starting position
        RPS best = null;
        int start = -1, score = -1;
        for (int i = 0; i < n; i++)
            for (RPS c : RPS.values()) {
                if (c.fight(p[i]) != 1)
                    continue;
                for (int j = 0, wins = 0; j < n && c.fight(p[(j + i) % n]) != -1; j++) {
                    wins += c.fight(p[(j + i) % n]);
                    if (wins > score) {
                        best = c;
                        start = i;
                        score = wins;
                    }
                }
            }

        // Print best move and starting position
        System.out.println(best);
        System.out.println(start);
    }
}
