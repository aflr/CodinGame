import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); in.nextLine();
        for (int i = 0; i < N; i++) {
            String x = in.nextLine();
            System.out.print(x + " ");
            Set<String> nums = new HashSet<>();
            while (nums.add(x)) {
                long num = 0;
                for (char c : x.toCharArray()) {
                    int d = ((int)c - '0');
                    num += d * d;
                }
                x = Long.toString(num);
            }
            System.out.println(nums.contains("1") ? ":)" : ":(");
        }
    }
}
