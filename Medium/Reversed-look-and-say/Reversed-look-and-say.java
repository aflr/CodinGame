import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> lns = new ArrayList<>();
        String rev = in.nextLine();
        while (lns.add(rev)) {
            String last = lns.get(lns.size() - 1);
            rev = revLookAndSay(last);
            if (rev == null || rev.equals(last)
                    || !lookAndSay(rev).equals(last)) {
                System.out.println(last);
                return;
            }
        }
    }

    private static String lookAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        char ch = s.charAt(0);
        int count = 1;
        for (int j = 1; j < s.length(); count++, j++)
            if (ch != s.charAt(j)) {
                sb.append(count).append(ch);
                count = 0;
                ch = s.charAt(j);
            }
        return sb.append(count).append(ch).toString();
    }

    private static String revLookAndSay(String s) {
        if (s.length() % 2 != 0)
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2)
            sb.append(s.substring(i + 1, i + 2).repeat(s.charAt(i) - '0'));
        return sb.toString();
    }
}
