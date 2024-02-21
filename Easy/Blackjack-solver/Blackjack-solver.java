import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Hand bank = new Hand(in.nextLine().split(" "));
        Hand player = new Hand(in.nextLine().split(" "));
        printWinner(player, bank);
    }

    private static class Hand {
        int cardCount;
        int score;
        int aceCount;

        public Hand(String[] cards) {
            this.cardCount = cards.length;
            this.score = 0;
            this.aceCount = 0;
            for (String card : cards) {
                this.score += cardValue(card);
                if (card.equals("A"))
                    this.aceCount++;
            }
            adjustScore();
        }

        public boolean blackjack() {
            return cardCount == 2 && score == 21;
        }

        private void adjustScore() {
            while (score > 21 && aceCount > 0) {
                score -= 10;
                aceCount--;
            }
        }

        private static int cardValue(String card) {
            switch (card) {
                case "A":
                    return 11;
                case "K":
                case "Q":
                case "J":
                    return 10;
                default:
                    return Integer.parseInt(card);
            }
        }
    }

    private static void printWinner(Hand player, Hand bank) {
        if (player.score > 21)
            System.out.println("Bank");
        else if (bank.score > 21)
            System.out.println(player.blackjack() ? "Blackjack!" : "Player");
        else if (player.score == bank.score) {
            if (player.blackjack() && !bank.blackjack())
                System.out.println("Blackjack!");
            else if (!player.blackjack() && bank.blackjack())
                System.out.println("Bank");
            else
                System.out.println("Draw");
        } else
            System.out.println(player.score > bank.score ? "Player" : "Bank");
    }
}
