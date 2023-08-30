import java.util.*;

class Solution {
    private static class Word implements Comparable {
        public int score;
        public String word;
        public int tiebreak;

        public Word(String word, int tiebreak) {
            score = score(word);
            this.word = word;
        }

        // Bigger score goes first. If equal scores, smaller tiebreak goes first
        @Override
        public int compareTo(Object o) {
            Word tmp = ((Word) o);
            int comp = tmp.score - score;
            return (comp != 0) ? comp : tiebreak - tmp.tiebreak;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        List<Word> wordList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            String W = in.nextLine();
            wordList.add(new Word(W, i));
        }
        wordList.sort(null);
        Map<Character, Integer> letters = new HashMap<>();
        char[] LETTERS = in.nextLine().toCharArray();
        for (char c : LETTERS)
            letters.put(c, letters.getOrDefault(c, 0) + 1);
        for (Word word : wordList) {
            if (canBeWritten(word.word, letters)) {
                System.out.println(word.word);
                return;
            }
        }
    }

    private static boolean canBeWritten(String word, Map<Character, Integer> letters) {
        Map<Character, Integer> wordf = new HashMap<>();
        for (char c : word.toCharArray())
            wordf.put(c, wordf.getOrDefault(c, 0) + 1);
        for (Map.Entry<Character, Integer> entry : wordf.entrySet())
            if (!letters.containsKey(entry.getKey()) || letters.get(entry.getKey()) < entry.getValue())
                return false;
        return true;
    }

    private static int score(String s) {
        int score = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'q':
                case 'z':
                    score += 10;
                    break;
                case 'j':
                case 'x':
                    score += 8;
                    break;
                case 'k':
                    score += 5;
                    break;
                case 'f':
                case 'h':
                case 'v':
                case 'w':
                case 'y':
                    score += 4;
                    break;
                case 'b':
                case 'c':
                case 'm':
                case 'p':
                    score += 3;
                    break;
                case 'd':
                case 'g':
                    score += 2;
                    break;
                case 'e':
                case 'a':
                case 'i':
                case 'o':
                case 'n':
                case 'r':
                case 't':
                case 'l':
                case 's':
                case 'u':
                    score += 1;
                    break;
            }
        }
        return score;
    }
}
