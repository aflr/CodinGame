import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        char[] num = in.nextLine().toCharArray();
        // Count evens and odds
        int neven = 0;
        for (char c : num)
            neven += (c % 2 == 0) ? 1 : 0;

        // Separate arrays for evens and odds
        char[] evens = new char[neven];
        char[] odds = new char[num.length - neven];

        // Add all digits into their array (evens, odds), respecting order
        int ievens = 0, iodds = 0;
        for (char c : num) {
            if (c % 2 == 0)
                evens[ievens++] = c;
            else
                odds[iodds++] = c;
        }

        // Now print solution by looping both arrays at the same time
        for (int ie = 0, io = 0; ie + io < num.length;) {
            // If either array is empty, print from the other one
            if (ie == evens.length) {
                System.out.print(odds[io++]);
                continue;
            }
            if (io == odds.length) {
                System.out.print(evens[ie++]);
                continue;
            }
            // Compare and print the max of the two
            if (evens[ie] > odds[io])
                System.out.print(evens[ie++]);
            else
                System.out.print(odds[io++]);
        }
        System.out.println();
    }
}
