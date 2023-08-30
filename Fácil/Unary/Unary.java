import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String msg = in.nextLine();

        // Create binary String of the message
        char[] mchars = msg.toCharArray();
        StringBuilder sbbin = new StringBuilder();
        for (int i = 0; i < mchars.length; i++) {
            char c = mchars[i];
            for (int j = 6; j >= 0; j--) {
                sbbin.append((c >> j) & 1);
            }
        }
        String bin = sbbin.toString();

        // Create unary String of the binary String
        char[] bchars = bin.toCharArray();
        StringBuilder sbuna = new StringBuilder();
        char prev = '2';
        for (int i = 0, count = 0; i < bchars.length; i++) {
            char c = bchars[i];
            if (c != prev) {
                if (count != 0)
                    sbuna.append(" ");
                if (c == '0')
                    sbuna.append("00 0");
                else
                    sbuna.append("0 0");
                count = 1;
                prev = c;
            } else {
                sbuna.append("0");
                count++;
            }
        }
        System.out.println(sbuna.toString());
    }
}
