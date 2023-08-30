import java.util.*;
class Solution {

    private static class Transition {
        public char startState, input, endState;

        public Transition(char startState, char input, char endState) {
            this.startState = startState;
            this.input = input;
            this.endState = endState;
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        in.nextLine(); in.nextLine();
        int numberOfTransitions = in.nextInt(); in.nextLine();
        List<Transition> trans = new ArrayList<>(numberOfTransitions);
        for (int i = 0; i < numberOfTransitions; i++) {
            char[] t = in.nextLine().toCharArray();
            trans.add(new Transition(t[0], t[2], t[4]));
        }
        char startState = in.nextLine().charAt(0);
        char[] endStates = in.nextLine().replaceAll(" ", "").toCharArray();
        int numberOfWords = in.nextInt(); in.nextLine();
        nextword: for (int i = 0; i < numberOfWords; i++) {
            char[] word = in.nextLine().toCharArray();
            char state = startState;
            nextletter: for (int j = 0; j < word.length; j++) {
                for (Transition t : trans)
                    if (t.startState == state && t.input == word[j]) {
                        state = t.endState;
                        continue nextletter;
                    }
                System.out.println("false");
                continue nextword;
            }
            for (int j = 0; j < endStates.length; j++)
                if (state == endStates[j]) {
                    System.out.println("true");
                    continue nextword;
                }
            System.out.println("false");
        }
    }
}
