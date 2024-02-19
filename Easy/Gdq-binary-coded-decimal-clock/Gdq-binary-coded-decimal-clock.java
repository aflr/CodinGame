import java.util.*;

class Solution {
    public static void main(String args[]) {
        int[] d = Arrays.stream((new Scanner(System.in)).nextLine().substring(1)
                .replaceAll(":", "").split("")).mapToInt(Integer::parseInt).toArray();
        for (int i = 3; i >= 0; System.out.println("|"), i--)
            for (int j = 0; j < 6; j++)
                System.out.print("|" + (new String[] { "_____", "#####" })[d[j] >> i & 1]);
    }
}
