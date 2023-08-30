import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner b = new Scanner(System.in);
        int n = b.nextInt();
        for (int i = 0; i < n; i++) {
            int row = b.nextInt();
            int col = b.nextInt();
            int isWhite = b.nextInt();
            System.out.println((row - 7) * (col - 7) + isWhite >> 1);
        }
    }
}
