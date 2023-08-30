import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        char[] order = in.nextLine().toCharArray();
        int[] s = { 1, 1, 1, 1 };
        for (char c : order) {
            switch (c) {
                case 'U': s[1] += s[0]; s[0] = 1; s[2] *= 2; s[3] *= 2; break;
                case 'D': s[0] += s[1]; s[1] = 1; s[2] *= 2; s[3] *= 2; break;
                case 'L': s[0] *= 2; s[1] *= 2; s[3] += s[2]; s[2] = 1; break;
                case 'R': s[0] *= 2; s[1] *= 2; s[2] += s[3]; s[3] = 1; break;
            }
        }
        System.out.println(s[side(in.nextLine())]);
    }
    static int side(String side) {
        switch (side) {
            case "U": return 0;
            case "D": return 1;
            case "L": return 2;
            case "R": return 3;
        }
        return -1;
    }
}
