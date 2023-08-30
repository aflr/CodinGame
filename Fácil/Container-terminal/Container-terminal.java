import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); in.nextLine();
        for (int i = 0; i < N; i++)
            System.out.println(numStacks(in.nextLine().toCharArray()));
    }
    private static int numStacks(char[] cs) {
        int[] stacks = new int[26];
        Arrays.fill(stacks, 255);
        for (char c : cs)
            for (int i = 0; i < 26; i++)
                if (stacks[i] >= c) {
                    stacks[i] = c; break;
                }
        for (int i = 0; i < 26; i++) // Return index of first empty stack (255 value)
            if (stacks[i] == 255)
                return i;
        return 26;
    }
}
