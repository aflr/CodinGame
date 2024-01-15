import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        char[] xs = x.toCharArray();
        int n = in.nextInt();

        long xl = 0;
        xl += (xs[0] - 'A');
        xl *= 26;
        xl += (xs[1] - 'A');
        xl *= 26;
        xl += (xs[7] - 'A');
        xl *= 26;
        xl += (xs[8] - 'A');
        xl *= 999;
        xl += Integer.parseInt(x.substring(3, 6));

        xl += n;

        int[] last = new int[5];
        last[2] = (xl % 999 == 0) ? 999 : (int) xl % 999;
        xl /= 999;
        last[4] = (int) (xl % 26) + 'A';
        last[4] -= (last[2] == 999) ? 1 : 0;
        xl /= 26;
        last[3] = (int) (xl % 26) + 'A';
        xl /= 26;
        last[1] = (int) (xl % 26) + 'A';
        xl /= 26;
        last[0] = (int) (xl % 26) + 'A';
        xl /= 26;

        System.out.printf("%c%c-%03d-%c%c", last[0], last[1], last[2], last[3], last[4]);
    }
}
