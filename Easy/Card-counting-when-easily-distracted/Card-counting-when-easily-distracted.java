import java.util.*;

class Solution {

    private static final String VALIDCARDS = "A23456789TJQK";

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String[] streamOfConsciousness = in.nextLine().split("\\.");
        Deck deck = new Deck();
        for (String thought : streamOfConsciousness)
            if (thought.matches("^[" + VALIDCARDS + "]+$"))
                deck.removeCards(thought.toCharArray());
        System.out.printf("%d%%\n", Math.round(deck.countBelow(in.nextInt()) * 100f / deck.countTotal()));
    }

    private static class Deck {
        Map<Integer, Integer> cards; // <cardValue, cardCount>

        public Deck() {
            cards = new HashMap<>();
            for (int i = 1; i <= 9; i++)
                cards.put(i, 4);
            cards.put(10, 16);
        }

        public void removeCards(char[] cardsToRemove) {
            for (char card : cardsToRemove) {
                int cardValue = Math.min(VALIDCARDS.indexOf(card) + 1, 10);
                int prevCount = cards.get(cardValue);
                if (prevCount == 1)
                    cards.remove(cardValue);
                else
                    cards.put(cardValue, prevCount - 1);
            }
        }

        public int countBelow(int value) {
            return cards.entrySet().stream().filter(en -> en.getKey() < value).mapToInt(en -> en.getValue()).sum();
        }

        public int countTotal() {
            return cards.values().stream().mapToInt(n -> n).sum();
        }
    }
}
