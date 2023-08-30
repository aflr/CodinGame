import java.util.*;
class Solution {
    public static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String[] rotor = new String[3];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String op = in.nextLine();
        int rand = in.nextInt();
        in.nextLine();
        for (int i = 0; i < 3; i++)
            rotor[i] = in.nextLine();
        String msg = in.nextLine();
        if (op.equals("ENCODE"))    System.out.println(encode(msg, rand));
        else                        System.out.println(decode(msg, rand));
    }

    private static String encode(String msg, int rand) {
        String res = msg;
        res = shift(res, rand, 1);
        for (int i = 0; i < 3; i++)
            res = rot(res, alpha, rotor[i]);
        return res;
    }

    private static String decode(String msg, int rand) {
        String res = msg;
        for (int i = 2; i >= 0; i--)
            res = rot(res, rotor[i], alpha);
        res = shift(res, -rand, -1);
        return res;
    }

    private static String shift(String res, int rand, int inc) {
        StringBuilder sb = new StringBuilder();
        for (char c : res.toCharArray()) {
            sb.append(caesar(c, rand));
            rand += inc;
        }
        return sb.toString();
    }

    private static String rot(String res, String from, String to) {
        StringBuilder sb = new StringBuilder();
        for (char c : res.toCharArray())
            sb.append(to.charAt(from.indexOf(c)));
        return sb.toString();
    }

    private static char caesar(char c, int n) {
        int ch = c - 'A' + n;
        while (ch < 0)
            ch += 26;
        return (char) (ch % 26 + 'A');
    }
}
