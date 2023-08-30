import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine(), line2 = in.nextLine(), line3 = in.nextLine();
        int[] num = new int[line1.length() / 3];
        for (int i = 0; i < num.length; i++) {
            boolean[] segments = new boolean[7];
            segments[0] = line1.charAt(i * 3 + 1) != ' ';
            segments[1] = line2.charAt(i * 3) != ' ';
            segments[2] = line2.charAt(i * 3 + 1) != ' ';
            segments[3] = line2.charAt(i * 3 + 2) != ' ';
            segments[4] = line3.charAt(i * 3) != ' ';
            segments[5] = line3.charAt(i * 3 + 1) != ' ';
            segments[6] = line3.charAt(i * 3 + 2) != ' ';
            num[i] = sevenSegment(segments);
        }
        for (int d : num)
            System.out.print(d);
        System.out.println();
    }

    private static int sevenSegment(boolean[] s) {
        if (s[0]) {
            if (s[4]) {
                return s[2] ? (!s[3] ? 6 : s[1] ? 8 : 2) : 0;
            } else
                return s[1] ? (s[3] ? 9 : 5) : s[2] ? 3 : 7;
        } else
            return s[1] ? 4 : 1;
    }
}
