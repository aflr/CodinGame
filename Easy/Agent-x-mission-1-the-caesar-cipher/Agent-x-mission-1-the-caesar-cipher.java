import java.util.*;

class Solution {
    
    public static void main(String args[]) {
        var in = new Scanner(System.in);
        String ciphertext = in.nextLine(), word = in.next(), plaintext;
        int i = 0;
        do plaintext = shiftBy(ciphertext, i++);
        while (Arrays.stream(plaintext.split("[ ,.?;:!]")).noneMatch(word::equals));
        System.out.printf("%d\n%s\n", i, plaintext);
    }

    private static String shiftBy(String str, int n) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int ch : str.toCharArray())
            sb.appendCodePoint((ch - n + 62) % 95 + 32);
        return sb.toString();
    }
}
