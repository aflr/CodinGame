import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt(); // L = width of a single character in this ascii art style
        int H = in.nextInt(); // H = height of a single character in this ascii art style
        in.nextLine();

        // The word we want to print in ascii art
        String word = in.nextLine();

        // Copy alphabet art into matrix
        char[][] art = new char[H][L * 27];
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            for (int j = 0; j < L * 27; j++) {
                art[i][j] = ROW.charAt(j);
            }
        }

        // Write letters from the word into solution matrix
        char[][] sol = new char[H][L * word.length()];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // Find the character's index: A -> 0, B -> 1, ..., Z -> 25, /\@+-[]{}? -> 26
            int index = ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                ? (Character.toUpperCase(c) - 'A') : 26;

            // Build solution matrix
            for (int z = 0; z < H; z++) {
                for (int r = 0; r < L; r++) {
                    sol[z][i * L + r] = art[z][index * L + r];
                }
            }
        }

        // Print solution matrix
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < L * word.length(); j++) {
                System.out.print(sol[i][j]);
            }
            System.out.println();
        }
    }
}
