import java.util.*;
import java.util.regex.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        for (int i = 0; i < 26; i++) {
            if (Pattern.compile("(.*)\\bCHIEF\\b(.*)").matcher(text).lookingAt()) {
                System.out.println(text);
                return;
            }
            text = shift(text);
        }
        System.out.println("WRONG MESSAGE");
    }

    private static String shift(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray())
            sb.append(c == ' ' ? ' ' : (char) ((c + 1 - 'A') % 26 + 'A'));
        return sb.toString();
    }
}
