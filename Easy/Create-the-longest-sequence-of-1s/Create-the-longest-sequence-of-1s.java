import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String b = in.nextLine();

        String c = b.replaceAll("101", "1,1");
        String[] parts = c.split("[0,]");

        int maxlen = 1;
        for (int i = 0; i < parts.length - 1; i++) {
            maxlen = Math.max(maxlen, parts[i].length() + parts[i + 1].length() + 1);
        }
        System.out.println(maxlen);
    }
}
